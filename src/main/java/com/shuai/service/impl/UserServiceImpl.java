package com.shuai.service.impl;

import com.shuai.dao.UserMapper;
import com.shuai.entity.User;
import com.shuai.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author shuaion 2017/7/14
 **/
@Service
public class UserServiceImpl implements IUserService{
    @Autowired
    private UserMapper userMapper;
    @Override
    public void insertUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public User getUserById(int id) {
        User user = userMapper.selectByPrimaryKey(id);
        System.out.println(user.toString());
        return user;
    }

}
