package com.example.demo.controller;

import com.example.demo.entity.OrderInfo;
import com.example.demo.service.OrderInfoService;

import com.example.demo.utils.ReturnT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderInfoController {
    @Autowired
    private OrderInfoService orderInfoService;

    @GetMapping("/order/info")
    public ReturnT<List<OrderInfo>> selectUserInfo() {
        System.out.println("获取商品订购数据==========");
        return orderInfoService.selectOrderInfo();
    }
}
