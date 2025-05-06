package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.ReturnT;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ReturnT<User> login(@RequestBody User _user, HttpSession session) {
        System.out.println("开始验证用户名和密码==========");
//        只能调用1次
        ReturnT<User> user=userService.login(_user.getUserName(), _user.getPassword());
        if (user.getCode() == 200)
            session.setAttribute("userName", _user.getUserName());
        return user;
    }

    @DeleteMapping("/logout")
    public String deleteSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate(); //删除session
        }
        System.out.println("用户已经登出");
        return ("用户已经登出");
    }

    @GetMapping("/list")
    public String list() {
        System.out.println("您已成功登录，并访问到了我");
        return ("您已成功登录，并访问到了我");
    }

    @GetMapping("/testFilter")
    public String testFilter() {
        System.out.println("过滤器放行，拦截器拦截");
        return ("过滤器放行，拦截器拦截");
    }

    @GetMapping("/testInterceptors")
    public String testInterceptors() {
        System.out.println("过滤器拦截，拦截器放行");
        return ("过滤器拦截，拦截器放行");
    }

}
