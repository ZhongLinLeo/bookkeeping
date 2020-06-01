package cn.leo.bookkeeping.user.common.handler;

import cn.leo.bookkeeping.user.common.enums.CallSystemResponseEnum;
import cn.leo.bookkeeping.user.common.enums.CommonResponseEnum;
import cn.leo.bookkeeping.user.common.response.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * exception handler
 *
 * @author leo.zl on 2020/5/7
 */
@Slf4j
public abstract class AbstractExceptionHandler {


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result<Boolean> handlerBaseException(Exception e) {
        log.warn("系统异常:{}", e.getMessage());
        return Result.warpResult(CommonResponseEnum.SYSTEM_ERROR);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public Result<Boolean> handle(MethodArgumentNotValidException e) {
        log.warn("参数校验失败:{}", e.getMessage());
        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        String tips = CallSystemResponseEnum.PARAM_INVALID.getResponseMessage();
        if (errors.size() > 0) {
            tips = errors.get(0).getDefaultMessage();
        }
        return Result.warpResult(CallSystemResponseEnum.PARAM_INVALID.getResponseCode(), tips);
    }
}
