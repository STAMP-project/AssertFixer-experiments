package com.cjyong.pcw.cp.main.exception.advice;

import com.cjyong.pcw.cp.main.MyJsonResult;
import com.cjyong.pcw.cp.main.exception.ParameterInValidException;
import com.cjyong.pcw.cp.main.exception.PermissionInSufficientException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA By
 * User: cjyong
 * Date: 2017/11/29
 * Time: 17:31
 * Description: Catch and handle all exception.
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class ExceptionHandlerAdvice {

    @ExceptionHandler(ParameterInValidException.class)
    public MyJsonResult handleParameterException(ParameterInValidException pex) {
        log.warn("BadRequest handling: " + pex.getMessage());
        return new MyJsonResult(pex.getMessage());
    }

    @ExceptionHandler(PermissionInSufficientException.class)
    public MyJsonResult handlePermissionException(PermissionInSufficientException pex) {
        log.warn("RequestOperation deny: " + pex.getMessage());
        return new MyJsonResult(pex.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public MyJsonResult handleRuntimeException(RuntimeException pex) {
        log.warn("Github update deny: " + pex.getMessage());
        return new MyJsonResult(pex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public MyJsonResult handleException(Exception e, HttpServletRequest request) {
        log.error("uri:{} | exception: ", request.getRequestURI(), e.getMessage());
        e.printStackTrace();
        return new MyJsonResult(e.getMessage());
    }
}
