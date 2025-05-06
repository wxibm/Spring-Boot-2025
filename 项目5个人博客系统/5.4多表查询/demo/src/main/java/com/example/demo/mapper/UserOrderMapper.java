package com.example.demo.mapper;

import com.example.demo.entity.UserOrder;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserOrderMapper {
    List<UserOrder> selectUserOrder();
}
