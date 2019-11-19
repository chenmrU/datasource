package com.cmr.datasource.redis;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author chenmengrui
 * @Description: redis配置属性
 * @date 2019/11/18 16:03
 */
@Component
@ConfigurationProperties(prefix = "redis.cluster")
@Getter
@Setter
public class RedisClusterProperties {

    private List<String> nodes;

    private String password;

    private int maxIdle;

    private int minIdle;

    private int maxTotal;

    private int maxWait;

    private boolean testOnBorrow;

    private int connTimeout;

    private int soTimeout;

    private int maxAttempts;

}
