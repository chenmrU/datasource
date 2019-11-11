package com.cmr.datasource.service;

import com.cmr.datasource.dao.UserMapper;
import com.cmr.datasource.entity.User;
import com.cmr.datasource.entity.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据用户id获取用户信息
     * @param userId
     * @return
     */
    public User getUserById(Long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    /**
     * 根据用户名获取用户信息
     * @param username
     * @return
     */
    public User getUserByUsername(String username) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserNameEqualTo(username);
        List<User> users = userMapper.selectByExample(userExample);
        if (CollectionUtils.isEmpty(users)) {
            return null;
        }
        return users.get(0);
    }

}
