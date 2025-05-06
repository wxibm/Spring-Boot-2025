package com.example.demo.serviceImpl;

import com.example.demo.entity.UUID;
import com.example.demo.mapper.UUIDMapper;
import com.example.demo.service.UUIDService;
import com.example.demo.utils.ReturnT;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;


@Service
public class UUIDServiceImpl implements UUIDService {
    @Resource
    private UUIDMapper uuidMapper;

    public ReturnT<UUID> insertUUID(UUID uuid) {
        try {
            uuidMapper.insertUUID(uuid);
            return ReturnT.Success(uuid);
        } catch (Exception e) {
            return ReturnT.Failed(e.getMessage());
        }
    }
}
