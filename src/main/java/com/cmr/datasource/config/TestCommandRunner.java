package com.cmr.datasource.config;

import com.cmr.datasource.dao.UserMapper;
import com.cmr.datasource.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author chenmengrui
 * @Description: TODO
 * @date 2019/11/7 17:02
 */
@Slf4j
@Component
public class TestCommandRunner implements CommandLineRunner {

    @Resource
    private UserMapper userMapper;

    @Override
    public void run(String... args) throws Exception {
        User user = userMapper.selectByPrimaryKey(1L);
        log.info(user.toString());
    }

}
