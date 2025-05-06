package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.utils.ReturnT;
import java.util.List;

public interface UserService {
    public ReturnT<List<User>> login(String userName, String password);

    public String createToken(Object object);

//    public boolean checkToken(String keyToken,String valueUserId);

    public String getToken(String keyToken);

    public boolean deleteToken(String keyToken);
}
