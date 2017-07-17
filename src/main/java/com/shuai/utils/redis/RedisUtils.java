package com.shuai.utils.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.Set;

/**
 * redis命令集合
 *
 * @author shuaion 2017/7/17
 **/
@Component
public class RedisUtils {

    @Autowired
    private StringRedisTemplate redisTemplate;

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
}
