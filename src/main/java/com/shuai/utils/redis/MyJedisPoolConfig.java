package com.shuai.utils.redis;

import redis.clients.jedis.JedisPoolConfig;

/**
 * redis初始化实现
 *
 * @author shuaion 2017/7/17
 **/
public class MyJedisPoolConfig extends JedisPoolConfig {

    private int maxIdle;
    private int maxTotal;
    private long maxWaitMillis;
    private boolean testOnBorrow;

    public MyJedisPoolConfig(int maxIdle, int maxTotal, int maxWaitMillis, boolean testOnBorrow) {
        this.maxIdle = maxIdle;
        this.maxTotal = maxTotal;
        this.maxWaitMillis = maxWaitMillis;
        this.testOnBorrow = testOnBorrow;
    }

}
