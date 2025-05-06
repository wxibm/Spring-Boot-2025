package com.example.demo.service;

import com.example.demo.entity.UserOrder;
import com.example.demo.utils.ReturnT;

import java.util.List;

public interface UserOrderService {
    public ReturnT<List<UserOrder>> selectUserOrder();
}
