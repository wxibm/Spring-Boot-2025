package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LogTestController {
    private static Logger log = LoggerFactory.getLogger(LogTestController.class);

    @RequestMapping("/logTest")
    public void printLog() {
        log.trace("(1)trace");
        log.debug("(2)debug");
        log.info("(3)info");
        log.warn("(4)warn");
        log.error("(5)error");
    }
}
