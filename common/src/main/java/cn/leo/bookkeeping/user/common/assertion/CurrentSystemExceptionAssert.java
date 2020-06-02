package cn.leo.bookkeeping.user.common.assertion;

import cn.leo.bookkeeping.user.common.enums.ResponseCode;
import cn.leo.bookkeeping.user.common.exception.BaseException;
import cn.leo.bookkeeping.user.common.exception.CurrentSystemException;

/**
 * 当前系统异常asset
 *
 * @author leo.zl on 2020/5/7
 */
public interface CurrentSystemExceptionAssert extends ResponseCode, Assert {

    @Override
    default BaseException newException() {
        return new CurrentSystemException(this);
    }

    @Override
    default BaseException newException(String msg) {

        return new CurrentSystemException(this,  msg);
    }
}
