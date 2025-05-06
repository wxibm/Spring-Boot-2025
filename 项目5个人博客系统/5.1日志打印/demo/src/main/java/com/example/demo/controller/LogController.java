package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class LogController {
    @RequestMapping("/log")
    public void printLog() {
        log.trace("I am trace");
        log.debug("I am debug");
        log.info("I am info");
        log.warn("I am warn");
        log.error("I am error");
    }
}
