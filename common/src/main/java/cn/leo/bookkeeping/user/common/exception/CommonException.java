package cn.leo.bookkeeping.user.common.exception;


import cn.leo.bookkeeping.user.common.enums.ResponseCode;
import lombok.extern.slf4j.Slf4j;

/**
 * @author leo.zl on 2020/5/7
 */
@Slf4j
public class CommonException extends BaseException {

    public CommonException(ResponseCode responseCode) {
        super(responseCode);
        log.info("系统异常,info:{}", responseCode.getResponseMessage());
    }

    public CommonException(ResponseCode responseCode, String message) {
        super(responseCode,  message);
    }
}
