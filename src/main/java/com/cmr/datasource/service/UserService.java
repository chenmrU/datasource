package com.cmr.datasource.service;

import com.alibaba.fastjson.JSON;
import com.cmr.datasource.constants.ResponseCode;
import com.cmr.datasource.dao.UserMapper;
import com.cmr.datasource.entity.User;
import com.cmr.datasource.entity.UserExample;
import com.cmr.datasource.entity.req.RegisterReq;
import com.cmr.datasource.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
@Slf4j
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

    /**
     * 注册
     * @param req
     */
    public void register(RegisterReq req) {
        log.info("[UserService.register] param is {}", JSON.toJSONString(req));
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserNameEqualTo(req.getUsername());
        User exist = this.getUserByUsername(req.getUsername());
        if (exist != null) {
            BizException.throwout(ResponseCode.USER_NAME_EXIST);
        }

        long count = userMapper.countByExample(new UserExample());
        User user = new User();
        user.setUserId(count + 1);
        user.setUserName(req.getUsername());
        user.setUserPassword(req.getPassword());
        int result = userMapper.insert(user);
        if (result != 1) {
            log.info("[UserService.register] fail, user is {}", JSON.toJSONString(user));
            BizException.throwout(ResponseCode.REGISTER_FAIL);
        }
    }


}
