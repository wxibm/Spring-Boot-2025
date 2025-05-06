package com.example.demo.controller;

import com.example.demo.entity.UUID;
import com.example.demo.service.UUIDService;
import com.example.demo.utils.ReturnT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UUIDController {
    @Autowired
    private UUIDService uuidService;

    @PostMapping("/uuid")
    public ReturnT<UUID> insertUUID(@RequestBody UUID uuid) {
        return uuidService.insertUUID(uuid);
    }
}
