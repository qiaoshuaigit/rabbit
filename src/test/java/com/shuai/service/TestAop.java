package com.shuai.service;

import com.shuai.entity.User;
import com.shuai.utils.redis.RedisUtils;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 业务层代码测试
 *
 * @author shuaion 2017/7/14
 *
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class TestAop {

    @Autowired
    private IUserService userService;

    @org.junit.Test
    public void test(){
        userService.updateUser(null);
    }


}
