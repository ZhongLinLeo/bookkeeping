package cn.leo.bookkeeping.enums;

import cn.leo.bookkeeping.assertion.CallSystemExceptionAssert;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 调用方异常
 *
 * @author leo.zl on 2020/6/1
 */
@Getter
@AllArgsConstructor
public enum CallSystemResponseEnum implements CallSystemExceptionAssert {


    /**
     * 参数无效
     */
    CALL_SYSTEM_ERROR("A10000", "调用方异常"),

    /**
     * 参数无效
     */
    PARAM_INVALID("A10001", "参数无效"),

    /**
     * 该手机号码已经注册
     */
    USER_EXIST("A10002", "该手机号码已经注册"),

    /**
     * 该手机号码已经注册
     */
    PASSWORD_PARSE_ERROR("A10003", "密码解析失败"),
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
