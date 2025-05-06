package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.MD5;
import com.example.demo.utils.ReturnT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user")//添加用户数据
    public ReturnT<User> insertUser(@Validated @RequestBody User user, BindingResult results) {
        if (results.hasErrors()) {
            String msg = "";
            //遍历错误集合
            for (ObjectError error : results.getAllErrors()) {
                msg+= error.getDefaultMessage()+"-";
            }
            return ReturnT.FORMAT_ERROR(msg);
        }
        return userService.insertUser(user);
    }

}
