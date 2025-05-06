package com.example.demo.utils;

import com.example.demo.entity.Module;
import com.example.demo.mapper.UserRoleModuleMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

//第一步：使用@Component注解
@Component
public class UserAuthority {
    //    第二步：@Autowired注册Mapper层接口
    @Autowired
    private UserRoleModuleMapper userRoleModuleMapper;

    //    第三步：添加一个你需要用到的类的静态字段
    public static UserAuthority userAuthority;

    //    第四步：用@PostConstruct注入bean，声明init()方法，进行初始化挂载
    @PostConstruct
    public void init() {
        userAuthority = this;
//        第五步：调用mapper或service接口
        userAuthority.userRoleModuleMapper = this.userRoleModuleMapper;
    }

    public boolean check(String userId, String url) {
        try {
            boolean b = false;
            List<Module> module = userAuthority.userRoleModuleMapper.selectModuleByUser(userId).getModuleList();
            for (Module m : module) {
//                System.out.println(m.getModuleUrl());
                if (url.equals(m.getModuleUrl()))
                    b = true;
            }
            return b;
        } catch (Exception e) {
            return false;
        }
    }
}
