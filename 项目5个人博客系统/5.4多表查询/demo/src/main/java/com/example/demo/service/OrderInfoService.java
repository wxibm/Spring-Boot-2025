package com.example.demo.service;

import com.example.demo.entity.OrderInfo;
import com.example.demo.utils.ReturnT;

import java.util.List;

public interface OrderInfoService {
    public ReturnT<List<OrderInfo>> selectOrderInfo();
}
