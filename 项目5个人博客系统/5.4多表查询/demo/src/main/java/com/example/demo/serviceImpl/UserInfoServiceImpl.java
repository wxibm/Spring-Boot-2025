package com.example.demo.serviceImpl;

import com.example.demo.entity.UserInfo;
import com.example.demo.mapper.UserInfoMapper;
import com.example.demo.service.UserInfoService;
import com.example.demo.utils.ReturnT;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoMapper userInfoMapper;

    public ReturnT<List<UserInfo>> selectUserInfo() {
        try {
            return ReturnT.Success(userInfoMapper.selectUserInfo());
        } catch (Exception e) {
            return ReturnT.Failed(e.getMessage());
        }
    }
}
