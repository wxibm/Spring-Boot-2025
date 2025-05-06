package com.example.demo.mapper;

import com.example.demo.entity.FILE;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface FileMapper {
    int insertFile(FILE fILE);
}
