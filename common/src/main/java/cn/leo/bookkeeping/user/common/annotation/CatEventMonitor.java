package cn.leo.bookkeeping.user.common.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * cat event监控
 *
 * @author create by leo.zl on 2020/9/27
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CatEventMonitor {

    /**
     * 事件名称
     *
     * @return 事件触发的名称
     */
    @AliasFor("value")
    String eventName() default "";


    /**
     * 成功事件名称
     *
     * @return 事件触发成功的名称
     */
    String eventSuccessName() default "";


    /**
     * 失败事件名称
     *
     * @return 事件触发失败的名称
     */
    String eventFailedName() default "";
}
