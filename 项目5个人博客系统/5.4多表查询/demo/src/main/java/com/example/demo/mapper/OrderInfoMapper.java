package com.example.demo.mapper;

import com.example.demo.entity.OrderInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderInfoMapper {
    List<OrderInfo> selectOrderInfo();
}
