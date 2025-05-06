package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest//1、表明当前单元测试是运行在Spring Boot环境中的
class UserMapperTest {
    //2、注入测试对象
    @Autowired
    private UserMapper userMapper;
    @Test
    void selectByPrimaryKey() {
        //3、添加单元测试的业务代码
        User user=userMapper.selectByPrimaryKey(1);
        System.out.println(user);
    }
}