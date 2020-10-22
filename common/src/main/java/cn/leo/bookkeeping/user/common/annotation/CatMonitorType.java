package cn.leo.bookkeeping.user.common.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * 每个业务链入口处标明该业务链监控类型
 *
 * @author create by leo.zl on 2020/9/27
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CatMonitorType {

    /**
     * 业务监控的类型，如果需要对某个业务链进行监控，则需要在该业务链入口处标明Type
     *
     * @return 监控的类型
     */
    @AliasFor("value")
    String businessMonitorType();
}
