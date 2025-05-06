package com.example.demo.controller;

import com.example.demo.entity.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @GetMapping("/users/{userName}/{password}")
    public String getUserByUrl(@PathVariable(value = "userName") String name,@PathVariable(value = "password") String pass){
        return "用户名：userName="+name+"，密码：password="+pass+"。";
    }

    @GetMapping("/user")
    public String getUser(@RequestParam("userName") String name,@RequestParam("password") String pass){
        return "用户名：userName="+name+"，密码：password="+pass+"。";
    }

    @PostMapping("/user")
    public String insertUser(@RequestBody User user) {
        return "用户名：userName="+user.getUserName()+"，密码：password="+user.getPassword()+"。";
    }

}
