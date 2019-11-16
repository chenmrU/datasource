package com.cmr.datasource.handler;

import com.cmr.datasource.constants.ResponseCode;
import com.cmr.datasource.entity.resp.Response;
import com.cmr.datasource.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;

/**
 * @author chenmengrui
 * @Description: 统一处理异常
 * @date 2019/11/11 18:51
 */
@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 捕获 UnauthorizedException
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedException.class)
    public Response handleUnauthorizedException(UnauthorizedException e) {
        log.error(e.getMessage());
        return new Response<>(ResponseCode.UNAUTHORIZED, e.getMessage());
    }

    /**
     * 捕获业务异常
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(BizException.class)
    public Response handleBizException(BizException e) {
        log.error(e.getMessage());
        return new Response(e.getResponseCode());
    }

    /**
     * 捕获参数异常（实体对象传参）
     * @param e
     * @return
     */
    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response validExceptionHandler(BindException e) {
        StringBuilder errorMsg = new StringBuilder();
        for (FieldError fieldError : e.getFieldErrors()) {
            errorMsg.append(fieldError.getField()).append(fieldError.getDefaultMessage()).append(',');
        }
        errorMsg = new StringBuilder(errorMsg.substring(0, errorMsg.length() - 1));
        log.error(errorMsg.toString());
        return new Response<>(500, "参数错误", errorMsg.toString());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response handleConstraintViolationException(ConstraintViolationException e) {
        StringBuilder errorMsg = new StringBuilder();
        for (ConstraintViolation<?> constraintViolation : e.getConstraintViolations()) {
            Path path = constraintViolation.getPropertyPath();
            String[] pathArr = StringUtils.splitByWholeSeparatorPreserveAllTokens(path.toString(), ".");
            errorMsg.append(pathArr[1]).append(constraintViolation.getMessage()).append(',');
        }
        errorMsg = new StringBuilder(errorMsg.substring(0, errorMsg.length() - 1));
        log.error(errorMsg.toString());
        return new Response<>(500, "参数错误", errorMsg.toString());
    }

    /**
     * 捕获其他所有异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Response globalException(Exception e) {
        log.error(e.getMessage());
        return new Response<>(500, "系统异常", e.getMessage());
    }

}
