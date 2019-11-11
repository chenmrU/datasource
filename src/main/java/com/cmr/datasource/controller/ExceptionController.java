package com.cmr.datasource.controller;

import com.cmr.datasource.constants.ResponseCode;
import com.cmr.datasource.entity.resp.Response;
import com.cmr.datasource.exception.UnauthorizedException;
import org.apache.shiro.ShiroException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author chenmengrui
 * @Description: TODO
 * @date 2019/11/11 18:51
 */
@RestControllerAdvice
public class ExceptionController {

    /**
     * 捕获Shiro异常
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(ShiroException.class)
    public Response handle401(ShiroException e) {
        return new Response<>(ResponseCode.UNAUTHORIZED, e.getMessage());
    }

    /**
     * 捕获UnauthorizedException
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedException.class)
    public Response handle401(UnauthorizedException e) {
        return new Response<>(ResponseCode.UNAUTHORIZED, e.getMessage());
    }

    /**
     * 捕获其他所有异常
     * @param request
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response globalException(HttpServletRequest request, Throwable ex) {
        return new Response<>(getStatus(request).value(), ex.getMessage(), null);
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }

}
