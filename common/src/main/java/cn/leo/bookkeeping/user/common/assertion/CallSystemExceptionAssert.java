package cn.leo.bookkeeping.user.common.assertion;

import cn.leo.bookkeeping.user.common.enums.ResponseCode;
import cn.leo.bookkeeping.user.common.exception.BaseException;
import cn.leo.bookkeeping.user.common.exception.CallSystemException;

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
