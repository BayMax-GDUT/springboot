package com.cvaiedu.springboot.exception;

import com.cvaiedu.springboot.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
    private static Logger log = LoggerFactory.getLogger(ControllerAdvice.class);

    @ExceptionHandler(value = Exception.class)
    public Result exceptionHandler (Exception ex) {
        if (ex instanceof FrameworkException) {
            return Result.error(ex.getMessage());
        } else {
            return Result.error("系统错误，请联系管理员");
        }
    }
}
