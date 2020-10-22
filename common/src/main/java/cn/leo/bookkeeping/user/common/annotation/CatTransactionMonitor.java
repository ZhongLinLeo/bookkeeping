package cn.leo.bookkeeping.user.common.annotation;

import java.lang.annotation.*;

/**
 * 标明一个方法需要进行 CatTransaction 监控
 *
 * <b>前提是当前线程有相关的监控类型，即在当前业务线入口需要使用@CatMonitorType指明业务线监控类型</b>
 *
 * 并且可以标注监控名称
 *
 * @see CatMonitorType
 * @author create by leo.zl on 2020/9/26
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface CatTransactionMonitor {

    /**
     * cat transaction 监控名称
     *
     * 缺省为方法名称
     *
     * @return cat transaction 监控名称
     */
    String catTransactionName() default "";
}
