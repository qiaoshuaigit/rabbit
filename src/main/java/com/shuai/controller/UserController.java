package com.shuai.controller;

import com.shuai.entity.User;
import com.shuai.service.IUserService;
import com.shuai.utils.redis.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shuaion 2017/7/13
 **/

/**
 * @Transactional不起作用是因为 事物是属于父类容器中得bean 而controller是子容器中得bean
 * 子容器可以访问父类中得bean和方法 但父类不可以访问子类中得bean
 */

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
    @ResponseBody
    public Object getuser(Integer id) {
        User user = userService.getUserById(id);
        return user;
    }

    @ResponseBody
    @RequestMapping("/update")
    public String updateUser(){
        userService.updateUser(new User());
        return "SUCCESS";
    }

    @ResponseBody
    @RequestMapping("/insert")
    @Transactional
    public Object insertUser(User user){

        int id = userService.insertUser(user);

        return id;
    }

    @ResponseBody
    @RequestMapping("/setRedisList")
    public Object setRedisList(String flag,String name){
        List list = new ArrayList();
        list.add(name);
        Long id = redisUtils.lpush(flag,list);
        return id;
    }
    @ResponseBody
    @RequestMapping("/lpop")
    public Object getRedisList(String flag){
        return redisUtils.lpop(flag);
    }

    @ResponseBody
    @RequestMapping("/keys")
    public Object getKeyList(String flag){
        return redisUtils.getKeys(flag);
    }

    @ResponseBody
    @RequestMapping("/values")
    public Object values(String flag){
        return redisUtils.lrangeAll(flag);
    }

}
