package com.cmr.datasource.entity.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author chenmengrui
 * @Description: TODO
 * @date 2019/11/11 17:26
 */
@Data
@ApiModel("登录请求实体")
public class LoginReq {

    @ApiModelProperty("用户名")
    @NotNull(message = "用户名不能为空")
    private String username;

    @ApiModelProperty("密码")
    @NotNull(message = "密码不能为空")
    private String password;

}
