package com.shuai.service;

import com.shuai.entity.User;

public interface IUserService {
    int insertUser(User user);
    User getUserById(int id);
    Object updateUser(User user);
}
