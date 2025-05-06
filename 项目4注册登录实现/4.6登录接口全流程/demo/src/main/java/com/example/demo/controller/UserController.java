package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Object login(@RequestBody User _user) {
        System.out.println("开始验证用户名和密码==========");
        Object user = userService.login(_user.getUserName(), _user.getPassword());
        return user;
    }

    @DeleteMapping("/logout")
    public void deleteToken(HttpServletRequest request) {
        String token = request.getHeader("token");
        userService.deleteToken(token);
        System.out.println("用户已注销");
    }

    @GetMapping("/list")
    public String list(@RequestHeader("token") String token) {
        if (StringUtils.isEmpty(userService.getToken(token))) {
            System.out.println("走控制层提示登录");
            return ("走控制层提示登录");
        } else {
            System.out.println("获取user对象：" + userService.getToken(token));
            System.out.println("您已成功登录，并访问到了我");
            return ("您已成功登录，并访问到了我");
        }
    }

    @GetMapping("/register")
    public void register() {
        System.out.println("用户注册");
    }
}