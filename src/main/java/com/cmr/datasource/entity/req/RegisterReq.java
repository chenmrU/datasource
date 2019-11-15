package com.cmr.datasource.entity.req;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author chenmengrui
 * @Description: 注册实体
 * @date 2019/11/15 17:59
 */
@Data
public class RegisterReq {

    @NotNull(message = "账号不能为空")
    private String username;

    @NotNull(message = "密码不能为空")
    private String password;

}
