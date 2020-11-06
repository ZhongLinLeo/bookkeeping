package cn.leo.bookkeeping.aspect;

import cn.leo.bookkeeping.annotation.CatMonitorType;
import cn.leo.bookkeeping.config.CatMonitorThreadLocalInfo;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 *
 *
 * @author create by leo.zl on 2020/9/27
 */
@Configuration
@Aspect
@Order(1)
public class CatMonitorEntranceAspect {

    /**
     * 业务线入口
     */
    @Pointcut("@annotation(cn.leo.bookkeeping.annotation.CatMonitorType)")
    public void pointCut() {
        // no need
    }

    /**
     * 在入口处将类型信息注入
     *
     * @param catMonitorType 监控类型
     */
    @Before("pointCut()&&@annotation(catMonitorType)")
    public void registerMonitorType(CatMonitorType catMonitorType) {

        // 对于当前线程已经存在类型的信息直接返回，以最初的为准
        String monitorType = CatMonitorThreadLocalInfo.getCatMonitorType();
        if (StringUtils.isNotBlank(monitorType)) {
            return;
        }

        monitorType = catMonitorType.businessMonitorType();
        CatMonitorThreadLocalInfo.setCatMonitorType(monitorType);
    }

    /**
     * 关闭资源
     */
    @After("pointCut()")
    public void closeResource() {
        CatMonitorThreadLocalInfo.removeThreadLocal();
    }
}
