package com.cmr.datasource.constants;

import lombok.Getter;

/**
 * @author chenmengrui
 * @Description: TODO
 * @date 2019/11/11 17:44
 */
@Getter
public enum ResponseCode {

    SUCCESS(200, "success"),

    LOGIN_SUCCESS(200, "登录成功"),

    UNAUTHORIZED(401, "认证不通过"),

    SERVICE_ERROR(400, "服务异常"),

    USER_NAME_EXIST(101, "用户名重复"),

    REGISTER_FAIL(102, "注册用户失败")

    ;

    private int code;
    private String message;

    ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
