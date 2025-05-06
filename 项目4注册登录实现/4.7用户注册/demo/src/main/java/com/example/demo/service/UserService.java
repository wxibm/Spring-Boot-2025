package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.utils.ReturnT;

public interface UserService {
    public ReturnT<User> insertUser(User user);
}
