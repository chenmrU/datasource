package com.cmr.datasource.redis;

import lombok.extern.slf4j.Slf4j;
/*import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;*/

import java.util.Set;

/**
 * @author chenmengrui
 * @Description: redisCluster
 * @date 2019/11/18 16:13
 */
@Slf4j
public class RedisClusterPipeline /*extends JedisCluster*/ {

   /* public RedisClusterPipeline(Set<HostAndPort> nodes,
                                int connectionTimeout,
                                int soTimeout,
                                int maxAttempts,
                                String password,
                                GenericObjectPoolConfig poolConfig) {
        super(nodes, connectionTimeout, soTimeout, maxAttempts, password, poolConfig);
        super.connectionHandler = new RedisSlotCustomConnectionHandler(nodes,
                poolConfig, connectionTimeout, soTimeout, password);
    }

    public RedisSlotCustomConnectionHandler getConnectionHandler() {
        return (RedisSlotCustomConnectionHandler) this.connectionHandler;
    }

    public void refreshCluster() {
        log.info("renew redis slot cluster");
        connectionHandler.renewSlotCache();
    }*/


}
