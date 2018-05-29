package com.shuai.controller;

import com.shuai.entity.User;
import com.shuai.service.IUserService;
import com.shuai.utils.redis.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author shuaion 2017/7/13
 **/
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @Autowired
    private RedisUtils redisUtils;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @ResponseBody
    @RequestMapping("index")
    public Object index() {
        logger.info("=========hello=========");
        return "index";
    }

    @RequestMapping("/getuser")
    public String getuser() {

        User user = new User();
        user.setName("张三");
        user.setAge(12);
        user.setAddress("中国长春");
        user.setPassWord("123456");
        userService.insertUser(user);
        System.out.println("-----getuser------");
        userService.getUserById(1);
        System.out.println(user.toString());

        return "index";
    }

    @ResponseBody
    @RequestMapping("/update")
    public String updateUser(){
        userService.updateUser(new User());
        return "SUCCESS";
    }
}
