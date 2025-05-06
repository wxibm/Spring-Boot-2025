package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.ReturnT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    /*AAAAAAAAAAAAAAAAAAAA*/
    @GetMapping("/users/list")//获取所有用户数据
    public ReturnT<List<User>> selectAllUsers() {
        System.out.println("获取所有用户数据==========");
        return userService.selectAllUsers();
    }

    /*BBBBBBBBBBBBBBBBBBBB*/
    @GetMapping("/users/page")//获取分页用户数据
    public ReturnT<List<User>> selectAllUsers(@RequestParam(value = "pageNum", defaultValue = "1") String pageNum,
                                               @RequestParam(value = "pageSize", defaultValue = "10") String pageSize){
        System.out.println("获取分页用户数据==========");
        return userService.findAllWithPagination(pageNum, pageSize);
    }

    /*CCCCCCCCCCCCCCCCCCCC*/
    @GetMapping("/users/search")//获取查询用户数据
    public ReturnT<List<User>> selectBySearch(@RequestParam(name="condition") String condition,@RequestParam(name="content") String content){
        System.out.println("获取查询用户数据==========");
        return userService.selectBySearch(condition, content);
    }

    /*DDDDDDDDDDDDDDDDDDDD*/
    @GetMapping("/users/count")//获取用户记录总数
    public int selectUsersCount() {
        System.out.println("获取用户记录总数==========");
        return  userService.selectUsersCount();
    }

    /*EEEEEEEEEEEEEEEEEEEE*/
    @GetMapping("/users/{userId}")//获取地址栏参数值的用户数据
    public ReturnT<User> getUserByUrl(@PathVariable(value = "userId") String id) {
        System.out.println("获取地址栏参数值的用户数据=========="+id);
        return userService.selectByPrimaryKey(id);
    }

    /*EEEEEEEEEEEEEEEEEEEE*/
    @GetMapping("/user")//获取Query参数值的用户数据
    public ReturnT<User> getUser(@RequestParam("userId") String id){
        System.out.println("获取Query参数值的用户数据=========="+id);
        return userService.selectByPrimaryKey(id);
    }

    /*FFFFFFFFFFFFFFFFFFFF*/
    @PostMapping("/user")//添加用户数据
    public ReturnT<User> insertUser(@Validated @RequestBody User user, BindingResult results) {
        if (results.hasErrors()) {
            String msg = "";
            //遍历错误集合
            for (ObjectError error : results.getAllErrors()) {
                msg+= error.getDefaultMessage()+"-";
            }
            return ReturnT.Failed(msg);
        }
        System.out.println("id==========" + user.getId());
        System.out.println("userName==========" + user.getUserName());
        System.out.println("password==========" + user.getPassword());
        System.out.println("userAvatar==========" + user.getUserAvatar());
        System.out.println("createDate==========" + user.getCreateDate());
        return userService.insertUser(user);
    }

    /*GGGGGGGGGGGGGGGGGGGG*/
    @DeleteMapping("/users/{userId}")//删除地址栏参数值的用户数据
    public ReturnT<User> deleteUserByUrl(@PathVariable(value = "userId") String id) {
        System.out.println("删除地址栏参数值的用户数据=========="+id);
        return userService.deleteUser(id);
    }

    /*GGGGGGGGGGGGGGGGGGGG*/
    @DeleteMapping("/user")//删除Query参数值的用户数据
    public ReturnT<User> deleteUser(@RequestParam("userId") String id){
        System.out.println("删除Query参数值的用户数据==========");
        return userService.deleteUser(id);
    }

    /*HHHHHHHHHHHHHHHHHHHH*/
    @PutMapping("/user")//修改用户所有数据
    public ReturnT<User> updateUser(@Validated @RequestBody User user) {
        System.out.println("修改用户所有数据==========");
        System.out.println("id==========" + user.getId());
        System.out.println("userName==========" + user.getUserName());
        System.out.println("password==========" + user.getPassword());
        System.out.println("userAvatar==========" + user.getUserAvatar());
        System.out.println("createDate==========" + user.getCreateDate());
        return userService.updateUser(user);
    }

    /*IIIIIIIIIIIIIIIIIIII*/
    @PatchMapping("/user")//修改用户部分数据
    public ReturnT<User> patchUser(@RequestBody User user) {
        System.out.println("修改用户部分数据==========");
        System.out.println("id==========" + user.getId());
        System.out.println("userName==========" + user.getUserName());
        System.out.println("password==========" + user.getPassword());
        System.out.println("userAvatar==========" + user.getUserAvatar());
        System.out.println("createDate==========" + user.getCreateDate());
        return userService.patchUser(user);
    }
}
