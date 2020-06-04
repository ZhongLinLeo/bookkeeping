package cn.leo.bookkeeping.user.common.enums;

import cn.leo.bookkeeping.user.common.assertion.CurrentSystemExceptionAssert;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author leo.zl on 2020/6/2
 */
@Getter
@AllArgsConstructor
public enum  CurrentSystemResponseEnum implements CurrentSystemExceptionAssert {


    /**
     * 系统错误
     */
    SUCCESS("B10000","系统处理异常"),

    /**
     * 注册失败
     */
    REGISTER_FAILED("B10001", "注册失败"),

    ;

    /**
     * 响应码
     */
    private String responseCode;

    /**
     * 响应信息
     */
    private String responseMessage;
}
