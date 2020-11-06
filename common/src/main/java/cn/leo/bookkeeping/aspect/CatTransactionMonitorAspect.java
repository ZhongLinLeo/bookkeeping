package cn.leo.bookkeeping.aspect;

import cn.leo.bookkeeping.annotation.CatTransactionMonitor;
import cn.leo.bookkeeping.config.CatMonitorThreadLocalInfo;
import cn.leo.bookkeeping.api.constant.CatMonitorConstants;
import cn.leo.bookkeeping.exception.BaseException;
import com.dianping.cat.Cat;
import com.dianping.cat.message.Transaction;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import javax.validation.constraints.NotNull;


/**
 * @author create by leo.zl on 2020/9/27
 */
@Configuration
@Aspect
@Order(98)
public class CatTransactionMonitorAspect {

    private static final ThreadLocal<Transaction> TRANSACTION_THREAD_LOCAL = new ThreadLocal<>();

    @Pointcut("@annotation(cn.leo.bookkeeping.annotation.CatTransactionMonitor)")
    public void pointCut() {
    }

    /**
     * catTransaction 监控
     *
     * @param catTransactionMonitor catTransaction 监控
     * @param point                 切点
     */
    @Around("pointCut()&&@annotation(catTransactionMonitor)")
    public Object createTransaction(ProceedingJoinPoint point, CatTransactionMonitor catTransactionMonitor) throws Throwable {

        final String catMonitorType = CatMonitorThreadLocalInfo.getCatMonitorType();
        if (StringUtils.isBlank(catMonitorType) || catTransactionMonitor == null) {
            return point.proceed();
        }

        initTransaction(point, catTransactionMonitor, catMonitorType);

        try {
            final Object result = point.proceed();
            recordSuccessTransaction();
            return result;
        } catch (Throwable throwable) {
            exceptionMonitor(throwable);
            throw throwable;
        } finally {
            closeResource();
        }
    }

    private void initTransaction(ProceedingJoinPoint point, @NotNull CatTransactionMonitor catTransactionMonitor,
                                 String catMonitorType) {
        String transactionName = catTransactionMonitor.catTransactionName();
        if (StringUtils.isBlank(transactionName)) {
            transactionName = point.getSignature().getName();
        }

        TRANSACTION_THREAD_LOCAL.set(Cat.newTransaction(catMonitorType, transactionName));
    }

    private void recordSuccessTransaction() {

        final Transaction transaction = TRANSACTION_THREAD_LOCAL.get();
        if (transaction == null) {
            return;
        }
        transaction.setStatus(CatMonitorConstants.EVENT_SUCCESS);
    }


    private void exceptionMonitor(Throwable throwable) {

        final Transaction transaction = TRANSACTION_THREAD_LOCAL.get();
        if (transaction == null) {
            return;
        }

        if (throwable instanceof BaseException) {
            final BaseException baseException = (BaseException) throwable;
            transaction.setStatus(baseException.getResponseCode().getResponseCode());
            return;
        }

        transaction.setStatus(throwable);
    }

    /**
     * 关闭资源
     */
    private void closeResource() {
        final Transaction transaction = TRANSACTION_THREAD_LOCAL.get();
        if (transaction == null) {
            return;
        }

        transaction.complete();
        TRANSACTION_THREAD_LOCAL.remove();
    }
}
