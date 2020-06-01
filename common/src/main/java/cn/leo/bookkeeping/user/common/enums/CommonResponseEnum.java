package cn.leo.bookkeeping.user.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author leo.zl on 2020/6/1
 */
@Getter
@AllArgsConstructor
public enum CommonResponseEnum implements ResponseCode {

    /**
     * 处理成功
     */
    SUCCESS("0000","处理成功"),

    /**
     *系统处理异常
     */
    SYSTEM_ERROR("9999","系统处理异常"),

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
