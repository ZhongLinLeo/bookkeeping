package cn.leo.bookkeeping.aspect;

import cn.leo.bookkeeping.annotation.CatEventMonitor;
import cn.leo.bookkeeping.config.CatMonitorThreadLocalInfo;
import cn.leo.bookkeeping.api.constant.CatMonitorConstants;
import cn.leo.bookkeeping.enums.ResponseCode;
import cn.leo.bookkeeping.exception.BaseException;
import com.dianping.cat.Cat;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;


/**
 * @author create by leo.zl on 2020/9/27
 */
@Configuration
@Aspect
@Order(99)
public class CatEventMonitorAspect {

    @Pointcut("@annotation(cn.leo.bookkeeping.annotation.CatEventMonitor)")
    public void pointCut() {
    }

    @Around("pointCut()&&@annotation(catEventMonitor)")
    public Object test(ProceedingJoinPoint point, CatEventMonitor catEventMonitor) throws Throwable {
        try {
            final Object result = point.proceed();
            monitorSuccessEvent(point, catEventMonitor);
            return result;
        } catch (Throwable throwable) {
            monitorExceptionEvent(point, catEventMonitor, throwable);
            throw throwable;
        }
    }

    private void monitorSuccessEvent(ProceedingJoinPoint point, CatEventMonitor catEventMonitor) {
        final String catMonitorType = CatMonitorThreadLocalInfo.getCatMonitorType();

        if (StringUtils.isBlank(catMonitorType)) {
            return;
        }

        String eventSuccessName = catEventMonitor.eventSuccessName();
        if (StringUtils.isBlank(eventSuccessName)) {
            eventSuccessName = catEventMonitor.eventName();
        }

        if (StringUtils.isBlank(eventSuccessName)) {
            eventSuccessName = point.getSignature().getName();
        }

        Cat.logEvent(catMonitorType, eventSuccessName);
    }

    private void monitorExceptionEvent(ProceedingJoinPoint point, CatEventMonitor catEventMonitor,
                                       Throwable throwable) {
        final String catMonitorType = CatMonitorThreadLocalInfo.getCatMonitorType();

        if (StringUtils.isBlank(catMonitorType)) {
            return;
        }

        String eventFailedName = catEventMonitor.eventFailedName();
        if (StringUtils.isBlank(eventFailedName)) {
            eventFailedName = catEventMonitor.eventName();
        }

        if (StringUtils.isBlank(eventFailedName)) {
            eventFailedName = point.getSignature().getName();
        }

        String failedStatus = CatMonitorConstants.EVENT_FAILED;
        String failedMessage = throwable.getMessage();
        if (throwable instanceof BaseException) {
            final BaseException baseException = (BaseException) throwable;
            final ResponseCode responseCode = baseException.getResponseCode();
            failedStatus = responseCode.getResponseCode();
            failedMessage = responseCode.getResponseMessage();
        }

        Cat.logEvent(catMonitorType, eventFailedName, failedStatus, failedMessage);
    }


}
