package com.example.demo.serviceImpl;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import com.example.demo.utils.ReturnT;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    public ReturnT<User> login(String userName, String password) {
        try {
            User user=userMapper.login(userName, password);
            List<User> listUser=userMapper.checkUserName(userName);
            if(listUser.isEmpty()) {
                return ReturnT.Failed("账号不存在。");
            }
            else if(user!=null) {
                return ReturnT.Success(user);
            }
            else{
                return ReturnT.Failed("密码不正确。");
            }
        } catch (Exception e) {
            return ReturnT.Failed(e.getMessage());
        }
    }
}