package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.utils.ReturnT;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    //创建列表，当做数据库表
   private List<User> users(){
        List<User> users = new ArrayList<>();
        User userA = new User();
        userA.setUserId(0);
        userA.setUserName("admin");
        userA.setPassword("12345");
        User userB = new User();
        userB.setUserId(1);
        userB.setUserName("users");
        userB.setPassword("12345");
        User userC = new User();
        userC.setUserId(2);
        userC.setUserName("bruce");
        userC.setPassword("12345");
        users.add(userA);
        users.add(userB);
        users.add(userC);
        return users;
    }

    @GetMapping("/users/list")//默认端口8080
    public ReturnT<List<User>> selectAllUsers() {
        System.out.println("获取所有用户数据。");
        return ReturnT.Success(users());
    }

    @GetMapping("/users/{userId}")
    public ReturnT<User> getUserByUrl(@PathVariable(value = "userId") Integer id){
        System.out.println("获取主键userId="+id+"的用户数据。");
        return ReturnT.Success(users().get(id));
    }

    @GetMapping("/user")//Apifox两种方法
    public ReturnT<User> getUser(@RequestParam("userId") Integer id){
        System.out.println("获取主键userId="+id+"的用户数据。");
        return ReturnT.Success(users().get(id));
    }

    @PostMapping("/user")
    public ReturnT<User> insertUser(@RequestBody User user) {
        System.out.println("添加用户数据。");
        System.out.println("userId==========" + user.getUserId());
        System.out.println("userName==========" + user.getUserName());
        System.out.println("password==========" + user.getPassword());
        return ReturnT.Success(user);
    }

    @DeleteMapping("/users/{userId}")
    public ReturnT<User> deleteUserByUrl(@PathVariable(value = "userId") Integer id) {
        System.out.println("删除地址栏参数userId="+id+"的用户。");
        return ReturnT.Success(users().get(id));
    }

    @DeleteMapping("/user")
    public ReturnT<User> deleteUser(@RequestParam("userId") Integer id){
        System.out.println("删除主键userId="+id+"的用户。");
        return ReturnT.Success(users().get(id));
    }

    @PutMapping("/user")
    public ReturnT<User> updateUser(@RequestBody User user) {
        System.out.println("修改主键userId="+user.getUserId()+"的用户全部数据。");
        System.out.println("userId==========" + user.getUserId());
        System.out.println("userName==========" + user.getUserName());
        System.out.println("password==========" + user.getPassword());
        return ReturnT.Success(user);
    }

    @PatchMapping ("/user")
    public ReturnT<User> patchUser(@RequestBody User user) {
        System.out.println("修改主键userId="+user.getUserId()+"的用户部分数据。");
        System.out.println("userId==========" + user.getUserId());
        System.out.println("userName==========" + user.getUserName());
        System.out.println("password==========" + user.getPassword());
        return ReturnT.Success(user);
    }

}
