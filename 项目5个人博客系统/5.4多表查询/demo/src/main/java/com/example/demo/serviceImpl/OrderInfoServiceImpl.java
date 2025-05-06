package com.example.demo.serviceImpl;

import com.example.demo.entity.OrderInfo;
import com.example.demo.mapper.OrderInfoMapper;
import com.example.demo.service.OrderInfoService;
import com.example.demo.utils.ReturnT;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderInfoServiceImpl implements OrderInfoService {
    @Resource
    private OrderInfoMapper orderInfoMapper;

    public ReturnT<List<OrderInfo>> selectOrderInfo() {
        try {
            return ReturnT.Success(orderInfoMapper.selectOrderInfo());
        } catch (Exception e) {
            return ReturnT.Failed(e.getMessage());
        }
    }
}
