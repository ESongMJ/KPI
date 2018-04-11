package cn.songmj.kpi.global;

import cn.songmj.kpi.enums.StatusCode;
import cn.songmj.kpi.result.Result;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by IntelliJ IDEA.
 *
 * @author luoliang
 * @date 2018/1/23
 * 错误处理类
 **/
@ControllerAdvice
@Component
@Log4j
public class GlobalExceptionHandler {
    /**
     * 参数校验异常处理
     *
     * @param exception
     * @return
     */
    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Object validateExceptionHandle(BindException exception) {
        log.error("bad request, " + exception.getMessage());
        exception.printStackTrace();
        return new Result(StatusCode.FAIL.getCode(), exception.getFieldError().getDefaultMessage());
    }

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Object defaultExceptionHandle(Exception exception) {
        log.error("bad request, " + exception.getMessage());
        exception.printStackTrace();
        return new Result(StatusCode.FAIL.getCode(), "系统内部错误");
    }
}
