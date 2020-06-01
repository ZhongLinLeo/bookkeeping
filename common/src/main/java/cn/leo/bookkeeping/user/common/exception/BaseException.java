package cn.leo.bookkeeping.user.common.exception;

import cn.leo.bookkeeping.user.common.enums.ResponseCode;
import lombok.Getter;

/**
 * @author leo.zl on 2020/5/7
 */
@Getter
public class BaseException extends RuntimeException {

    /**
     * 返回码
     */
    private ResponseCode responseCode;

    /**
     * 异常消息参数
     */
    protected Object[] args;

    public BaseException(ResponseCode responseCode) {
        super(responseCode.getResponseMessage());
        this.responseCode = responseCode;
    }

    public BaseException(String code, String msg) {
        super(msg);
        this.responseCode = new ResponseCode() {
            @Override
            public String getResponseCode() {
                return code;
            }

            @Override
            public String getResponseMessage() {
                return msg;
            }
        };
    }

    public BaseException(ResponseCode responseCode, Object[] args, String message) {
        super(message);
        this.responseCode = responseCode;
        this.args = args;
    }

    public BaseException(ResponseCode responseCode, String message) {
        super(message);
        this.responseCode = responseCode;
    }

    public BaseException(ResponseCode responseCode, Object[] args, String message, Throwable cause) {
        super(message, cause);
        this.responseCode = responseCode;
        this.args = args;
    }
}
