package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.ReturnT;
import com.google.gson.Gson;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ReturnT<List<User>> login(@RequestBody User _user) {
        System.out.println("开始验证用户名和密码==========");
        ReturnT<List<User>> user=userService.login(_user.getUserName(), _user.getPassword());
        if (user.getCode() == 200) {
//            Integer userId = user.getData().get(0).getId();
//            String token=tokenUtil.create(String.valueOf(userId));
//            介绍如果不格式化是何种格式
            Gson gson = new Gson();
            String token=userService.createToken(gson.toJson(user.getData().get(0)));
            System.out.println("token = " + token);
//            实际开发中，我们将token存储在浏览器的sessionStorage或者localStorage中
        }
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
        if(StringUtils.isEmpty(userService.getToken(token))) {
            System.out.println("走控制层提示登录");
            return ("走控制层提示登录");
        }
        else {
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
