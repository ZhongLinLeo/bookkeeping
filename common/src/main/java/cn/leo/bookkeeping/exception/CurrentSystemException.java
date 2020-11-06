package cn.leo.bookkeeping.exception;

import cn.leo.bookkeeping.enums.ResponseCode;
import lombok.extern.slf4j.Slf4j;

/**
 * @author leo.zl on 2020/6/2
 */
@Slf4j
public class CurrentSystemException extends BaseException {

    public CurrentSystemException(ResponseCode responseCode) {
        super(responseCode);
        log.info("系统异常,info:{}", responseCode.getResponseMessage());
    }

    public CurrentSystemException(ResponseCode responseCode, String message) {
        super(responseCode, message);
    }

}
