package com.shuai.service;

import com.shuai.entity.User;

public interface IUserService {
    void insertUser(User user);
    User getUserById(int id);
}
