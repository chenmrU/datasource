package com.cmr.datasource.exception;

/**
 * @author chenmengrui
 * @Description: TODO
 * @date 2019/11/11 11:53
 */
public class UnauthorizedException extends RuntimeException {

    public UnauthorizedException(String message) {
        super(message);
    }

    public UnauthorizedException() {
    }
}
