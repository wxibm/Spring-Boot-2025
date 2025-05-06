package com.example.demo.controller;

import com.example.demo.utils.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RedisController {
    @Autowired
    private RedisClient redisClient;

    @GetMapping("/create")
    public void create() {
        redisClient.set("key1的值","value1的值");
        redisClient.set("key2的值","value2的值");
        System.out.println("value1 = " + redisClient.get("key1的值"));
        System.out.println("value2 = " + redisClient.get("key2的值"));
    }

    @GetMapping("/delete")
    public void delete() {
        redisClient.remove("key1的值");
        System.out.println("value1 = " + redisClient.get("key1的值"));
        System.out.println("value2 = " + redisClient.get("key2的值"));
    }
}
