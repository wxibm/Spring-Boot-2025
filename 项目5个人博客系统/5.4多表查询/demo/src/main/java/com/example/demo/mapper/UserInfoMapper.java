package com.example.demo.mapper;

import com.example.demo.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserInfoMapper {
    List<UserInfo> selectUserInfo();
}
