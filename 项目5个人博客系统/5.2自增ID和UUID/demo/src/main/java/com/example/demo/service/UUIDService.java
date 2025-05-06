package com.example.demo.service;

import com.example.demo.entity.UUID;
import com.example.demo.utils.ReturnT;

public interface UUIDService {
    public ReturnT<UUID> insertUUID(UUID uuid);
}
