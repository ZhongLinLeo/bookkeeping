package cn.leo.bookkeeping.assertion;

import cn.leo.bookkeeping.enums.ResponseCode;
import cn.leo.bookkeeping.exception.BaseException;
import cn.leo.bookkeeping.exception.CallSystemException;

/**
 * @author leo.zl on 2020/5/9
 */
public interface CallSystemExceptionAssert extends ResponseCode, Assert {

    @Override
    default BaseException newException() {
        return new CallSystemException(this);
    }

    @Override
    default BaseException newException(String msg) {
        return new CallSystemException(this,  msg);
    }
}
