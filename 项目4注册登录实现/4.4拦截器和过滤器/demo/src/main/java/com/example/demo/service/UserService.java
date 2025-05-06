package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.utils.ReturnT;
import java.util.List;

public interface UserService {
    public ReturnT<User> login(String userName, String password);
}
