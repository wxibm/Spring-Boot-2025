package com.example.demo.controller;

import com.example.demo.entity.UserOrder;
import com.example.demo.service.UserOrderService;
import com.example.demo.utils.ReturnT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserOrderController {
    @Autowired
    private UserOrderService userOrderService;

    @GetMapping("/user/order")
    public ReturnT<List<UserOrder>> selectUserOrder() {
        System.out.println("获取用户订单==========");
        return userOrderService.selectUserOrder();
    }
}
