package com.example.demo.serviceImpl;

import com.example.demo.entity.UserOrder;
import com.example.demo.mapper.UserOrderMapper;
import com.example.demo.service.UserOrderService;
import com.example.demo.utils.ReturnT;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserOrderServiceImpl implements UserOrderService {
    @Resource
    private UserOrderMapper userOrderMapper;

    public ReturnT<List<UserOrder>> selectUserOrder() {
        try {
            return ReturnT.Success(userOrderMapper.selectUserOrder());
        } catch (Exception e) {
            return ReturnT.Failed(e.getMessage());
        }
    }
}
