package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.utils.ReturnT;

public interface UserService {
    public ReturnT<User> login(String userName, String password);

    public String createToken(Object object);

    public boolean checkToken(String keyToken,String valueUserId);

    public String getToken(String keyToken);

    public boolean deleteToken(String keyToken);
}
