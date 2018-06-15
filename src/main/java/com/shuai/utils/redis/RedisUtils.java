package com.shuai.utils.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * redis命令集合
 *
 * @author shuaion 2017/7/17
 *
 *  他们两者之间的区别主要在于他们使用的序列化类。
    RedisTemplate使用的是JdkSerializationRedisSerializer
    StringRedisTemplate使用的是StringRedisSerializer
 **/
@Component
public class RedisUtils {

    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    @Qualifier("redisHandle")
    private RedisTemplate redisHandler;

    /**
     * 字符串类型存储
     * @param key
     * @param val
     */
    public void set(String key,String val){
       redisTemplate.opsForValue().set(key,val);
    }

    /**
     * 获取字符串类型
     * @param key
     * @return
     */
    public String get(String key){
        String value = redisTemplate.opsForValue().get(key);
        if (StringUtils.isEmpty(value)){
            return "";
        }
        return value;
    }

    /**
     * 获取key集合
     * @param key
     * @return
     */
    public Set<String> keys(String key){
        Set<String> set = redisTemplate.keys(key);
        if (set==null||set.isEmpty()){
            return Collections.EMPTY_SET;
        }
        return set;
    }

    public Long lpush(Object key, Object value){
        return redisHandler.opsForList().leftPushAll(key,value);
    }

    public Object lpop(Object key){
       return redisHandler.opsForList().leftPop(key);
    }

    public Object getKeys(String key){
       return redisHandler.keys(key);
    }

    public Object lrangeAll(Object key){
        return redisHandler.opsForList().range(key,0,-1);
    }

}
