package com.cmr.datasource.redis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisSlotBasedConnectionHandler;
import redis.clients.jedis.exceptions.JedisNoReachableClusterNodeException;

import java.util.Set;

/**
 * @author chenmengrui
 * @Description: 获取对应的slot
 * @date 2019/11/18 16:23
 */
public class RedisSlotCustomConnectionHandler extends JedisSlotBasedConnectionHandler {


    public RedisSlotCustomConnectionHandler(Set<HostAndPort> nodes,
                                            GenericObjectPoolConfig poolConfig,
                                            int connectionTimeout,
                                            int soTimeout,
                                            String password) {
        super(nodes, poolConfig, connectionTimeout, soTimeout, password);
    }

    public JedisPool getJedisPoolFromSlot(int slot) {
        JedisPool jedisPool = cache.getSlotPool(slot);
        if (jedisPool != null) {
            return jedisPool;
        }
        renewSlotCache();
        jedisPool = cache.getSlotPool(slot);
        if (jedisPool != null) {
            return jedisPool;
        }
        throw new JedisNoReachableClusterNodeException("No reachable node in cluster for slot " + slot);
    }

}
