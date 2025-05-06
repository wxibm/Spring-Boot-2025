package com.example.demo.controller;

import com.example.demo.entity.RoleModuleEntity;
import com.example.demo.entity.UserRoleEntity;
import com.example.demo.entity.UserRoleModuleEntity;
import com.example.demo.service.UserRoleModuleService;
import com.example.demo.utils.ReturnT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserRoleModuleController {
    @Autowired
    private UserRoleModuleService userRoleModuleService;

    //@GetMapping("/userRoleEntity")
    @GetMapping("/user/role")
    public ReturnT<UserRoleEntity> selectRoleByUser(@RequestParam("userId") String userId) {
        return userRoleModuleService.selectRoleByUser(userId);
    }

    //@GetMapping("/roleModuleEntity")
    @GetMapping("/role/module")
    public ReturnT<RoleModuleEntity> selectModuleByRole(@RequestParam("roleId") String roleId) {
        return userRoleModuleService.selectModuleByRole(roleId);
    }

//    @GetMapping("/userRoleModuleEntity")
    @GetMapping("/user/module")
    public ReturnT<UserRoleModuleEntity> selectModuleByUser(@RequestParam("userId") String userId) {
        return userRoleModuleService.selectModuleByUser(userId);
    }

    @GetMapping("/system")
    public String system() {
        return ("系统管理模块");
    }

    @GetMapping("/role")
    public String role() {
        return ("角色管理模块");
    }

    @GetMapping("/department")
    public String department() {
        return ("部门管理模块");
    }

    @GetMapping("/teacher")
    public String teacher() {
        return ("教师管理模块");
    }

    @GetMapping("/class")
    public String _class() {
        return ("班级管理模块");
    }

    @GetMapping("/student")
    public String student() {
        return ("学生管理模块");
    }

    @GetMapping("/course")
    public String course() {
        return ("课程管理模块");
    }

    @GetMapping("/dormitory")
    public String dormitory() {
        return ("宿舍管理模块");
    }

    @GetMapping("/score")
    public String score() {
        return ("成绩管理模块");
    }

    @GetMapping("/leave")
    public String leave() {
        return ("请假管理模块");
    }
}
