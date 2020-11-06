package cn.leo.bookkeeping.exception;

import cn.leo.bookkeeping.enums.ResponseCode;
import lombok.extern.slf4j.Slf4j;

/**
 * @author leo.zl on 2020/6/2
 */
@Slf4j
public class CallSystemException extends BaseException {

    public CallSystemException(ResponseCode responseCode) {
        super(responseCode);
        log.info("调用参数异常,info:{}", responseCode.getResponseMessage());
    }

    public CallSystemException(ResponseCode responseCode, String message) {
        super(responseCode, message);
    }

}
