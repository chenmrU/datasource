package com.cmr.datasource.redis;

/*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;*/

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author chenmengrui
 * @Description: redis集群配置
 * @date 2019/11/18 16:01
 */
//@Configuration
//@ConditionalOnClass(JedisCluster.class)
public class RedisClusterConfig {

    /*//@Autowired
    private RedisClusterProperties redisClusterProperties;

    //@Bean
    public RedisConnectionFactory redisConnectionFactory() {
        RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration(redisClusterProperties.getNodes());
        redisClusterConfiguration.setPassword(RedisPassword.of(redisClusterProperties.getPassword()));
        return new JedisConnectionFactory(redisClusterConfiguration);
    }

    //@Bean
    public RedisClusterPipeline jedisCluster() {
        List<String> nodes = redisClusterProperties.getNodes();
        Set<HostAndPort> nodeSet = new HashSet<>();
        for (String node : nodes) {
            String[] hostPort = node.split(":");
            nodeSet.add(new HostAndPort(hostPort[0].trim(), Integer.parseInt(hostPort[1].trim())));
        }

        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // 最大空闲连接数, 默认8个
        jedisPoolConfig.setMaxIdle(redisClusterProperties.getMaxIdle());
        // 最小空闲连接数, 默认0
        jedisPoolConfig.setMinIdle(redisClusterProperties.getMinIdle());
        // 最大连接数, 默认8个
        jedisPoolConfig.setMaxTotal(redisClusterProperties.getMaxTotal());
        // 默认2秒
        jedisPoolConfig.setMaxWaitMillis(redisClusterProperties.getMaxWait());
        // 对拿到的connection进行validateObject校验
        jedisPoolConfig.setTestOnBorrow(redisClusterProperties.isTestOnBorrow());

        return new RedisClusterPipeline(nodeSet, redisClusterProperties.getConnTimeout(), redisClusterProperties.getSoTimeout(),
                redisClusterProperties.getMaxAttempts(), redisClusterProperties.getPassword(), jedisPoolConfig);
    }*/


}
