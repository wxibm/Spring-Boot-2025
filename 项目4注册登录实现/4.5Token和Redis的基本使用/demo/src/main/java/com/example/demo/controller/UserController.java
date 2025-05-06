package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.ReturnT;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ReturnT<User> login(@RequestBody User _user,HttpServletResponse response, HttpSession session) {
        System.out.println("开始验证用户名和密码==========");
        ReturnT<User> user=userService.login(_user.getUserName(), _user.getPassword());
        if (user.getCode() == 200) {
            String token=userService.createToken(user.getData());
            System.out.println("token = " + token);
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
            System.out.println("请先登录");
            return ("请先登录");
        }
        else {
            System.out.println("获取user对象：" + userService.getToken(token));
            System.out.println("您已成功登录，并访问到了我");
            return ("您已成功登录，并访问到了我");
        }
    }

}
