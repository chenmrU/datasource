package com.cmr.datasource.controller;

import com.auth0.jwt.exceptions.TokenExpiredException;
import com.cmr.datasource.constants.ResponseCode;
import com.cmr.datasource.entity.resp.Response;
import com.cmr.datasource.exception.UnauthorizedException;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.ShiroException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author chenmengrui
 * @Description: 统一处理异常
 * @date 2019/11/11 18:51
 */
@RestControllerAdvice
@Slf4j
public class ExceptionController {

    /**
     * 捕获UnauthorizedException
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler({UnauthorizedException.class, TokenExpiredException.class, ShiroException.class})
    public Response handle401(Exception e) {
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
