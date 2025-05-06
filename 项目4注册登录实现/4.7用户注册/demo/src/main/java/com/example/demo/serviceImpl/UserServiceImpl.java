package com.example.demo.serviceImpl;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import com.example.demo.utils.MD5;
import com.example.demo.utils.ReturnT;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    public ReturnT<User> insertUser(User user) {
        try {
            if(!userMapper.checkUserName(user.getUserName()).isEmpty()) {
                return ReturnT.USERNAME_EXISTS();
            }
            else {
                user.setPassword(MD5.encrypt(user.getPassword()+"clark"));
                userMapper.insertUser(user);
                return ReturnT.Success(user);
            }
        } catch (Exception e) {
            return ReturnT.Failed(e.getMessage());
        }
    }
}