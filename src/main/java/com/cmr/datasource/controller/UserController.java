package com.cmr.datasource.controller;

import com.cmr.datasource.dao.jpa.UserRepository;
import com.cmr.datasource.entity.jpa.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.Optional;

/**
 * @author chenmengrui
 * @Description: TODO
 * @date 2019/11/8 10:37
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("getUser")
    public UserEntity user(@RequestParam("userId") @NotNull Long userId) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(userId);
        return optionalUserEntity.orElse(null);
    }

}
