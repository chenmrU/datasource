package com.cmr.datasource.controller;

import com.cmr.datasource.constants.ResponseCode;
import com.cmr.datasource.entity.req.LoginReq;
import com.cmr.datasource.entity.req.RegisterReq;
import com.cmr.datasource.entity.resp.Response;
import com.cmr.datasource.entity.User;
import com.cmr.datasource.exception.BizException;
import com.cmr.datasource.exception.UnauthorizedException;
import com.cmr.datasource.service.UserService;
import com.cmr.datasource.shiro.JWTUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author chenmengrui
 * @Description: TODO
 * @date 2019/11/8 10:37
 */
@Api(value = "agent", description = "用户管理")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("查询用户信息")
    @GetMapping("userInfo")
    @RequiresPermissions("user:query")
    public User user() {
        return (User) SecurityUtils.getSubject().getPrincipal();
    }

    @ApiOperation("注册")
    @PostMapping("register")
    public Response register(@RequestBody @Valid RegisterReq req, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder errors = new StringBuilder();
            bindingResult.getAllErrors().forEach(objectError -> errors.append(objectError.getDefaultMessage()).append(","));
        }
        userService.register(req);
        return Response.buildSuccessResponse(true);
    }

    @ApiOperation("登录")
    @PostMapping("login")
    public Response<String> login(@RequestBody LoginReq req) {
        User user = userService.getUserByUsername(req.getUsername());
        if (!ObjectUtils.isEmpty(user) && user.getUserPassword().equals(req.getPassword())) {
            return new Response<>(ResponseCode.LOGIN_SUCCESS, JWTUtil.sign(req.getUsername(), req.getPassword()));
        }
        throw new UnauthorizedException();
    }

}
