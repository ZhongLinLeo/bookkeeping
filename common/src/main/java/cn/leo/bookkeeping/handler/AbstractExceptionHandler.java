package cn.leo.bookkeeping.handler;

import cn.leo.bookkeeping.enums.CommonResponseEnum;
import cn.leo.bookkeeping.exception.BaseException;
import cn.leo.bookkeeping.exception.CallSystemException;
import cn.leo.bookkeeping.exception.CommonException;
import cn.leo.bookkeeping.exception.CurrentSystemException;
import cn.leo.bookkeeping.response.Result;
import cn.leo.bookkeeping.enums.CallSystemResponseEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * exception handler
 *
 * @author leo.zl on 2020/5/7
 */
@Slf4j
@ControllerAdvice
public class AbstractExceptionHandler {

    @ExceptionHandler({
            CurrentSystemException.class,
            CommonException.class,
            CallSystemException.class
    })
    @ResponseBody
    public Result<Object> handlerBaseException(BaseException e) {
        log.info("统一异常处理:{}", e.getMessage());
        return Result.warpResult(e.getResponseCode());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result<Object> handlerBaseException(Exception e) {
        log.warn("系统异常:{}", e.getMessage());
        return Result.warpResult(CommonResponseEnum.SYSTEM_ERROR);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public Result<Object> handle(MethodArgumentNotValidException e) {
        log.warn("参数校验失败:{}", e.getMessage());
        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        String tips = CallSystemResponseEnum.PARAM_INVALID.getResponseMessage();
        if (errors.size() > 0) {
            tips = errors.get(0).getDefaultMessage();
        }
        return Result.warpResult(CallSystemResponseEnum.PARAM_INVALID.getResponseCode(), tips);
    }
}
