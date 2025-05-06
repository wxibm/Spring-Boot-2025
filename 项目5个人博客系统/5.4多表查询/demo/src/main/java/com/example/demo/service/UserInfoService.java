package com.example.demo.service;

import com.example.demo.entity.UserInfo;
import com.example.demo.utils.ReturnT;

import java.util.List;

public interface UserInfoService {
    public ReturnT<List<UserInfo>> selectUserInfo();
}
