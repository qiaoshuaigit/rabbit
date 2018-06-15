package com.shuai.service.impl;

import com.shuai.dao.UserMapper;
import com.shuai.entity.User;
import com.shuai.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author shuaion 2017/7/14
 **/
@Service
@Transactional
public class UserServiceImpl implements IUserService{
    @Autowired
    private UserMapper userMapper;
    @Override
    public int insertUser(User user) {
        userMapper.insert(user);
        //int i = 1/0;
        return user.getId();
    }

    @Override
    public User getUserById(int id) {
        User user = userMapper.selectByPrimaryKey(id);
        System.out.println(user.toString());
        return user;
    }

    @Override
    public Object updateUser(User user) {
        System.out.println("====UserServiceImpl==updateUser========");
        return "Success";
    }

}
