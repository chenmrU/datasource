package com.cmr.datasource.service;

import com.cmr.datasource.dao.UserMapper;
import com.cmr.datasource.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUserById(Long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

}
