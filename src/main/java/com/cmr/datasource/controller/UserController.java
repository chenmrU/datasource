package com.cmr.datasource.controller;

import com.cmr.datasource.dao.UserMapper;
import com.cmr.datasource.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * @author chenmengrui
 * @Description: TODO
 * @date 2019/11/8 10:37
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("getUser")
    public User user(@RequestParam("userId") @NotNull Long userId) {
        User user = userMapper.selectByPrimaryKey(1L);
        return user;
    }

}
