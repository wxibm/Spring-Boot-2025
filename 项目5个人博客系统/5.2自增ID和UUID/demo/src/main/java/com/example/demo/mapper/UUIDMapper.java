package com.example.demo.mapper;

import com.example.demo.entity.UUID;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UUIDMapper {
    int insertUUID(UUID uuid);
}
