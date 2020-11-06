package cn.leo.bookkeeping.assertion;

import cn.leo.bookkeeping.enums.ResponseCode;
import cn.leo.bookkeeping.exception.BaseException;
import cn.leo.bookkeeping.exception.CommonException;

/**
 * 公共的异常assert
 *
 * @author leo.zl on 2020/5/7
 */
public interface CommonExceptionAssert extends ResponseCode,Assert {

    @Override
    default BaseException newException() {
        return new CommonException(this);
    }

    @Override
    default BaseException newException(String msg) {

        return new CommonException(this,  msg);
    }
}
