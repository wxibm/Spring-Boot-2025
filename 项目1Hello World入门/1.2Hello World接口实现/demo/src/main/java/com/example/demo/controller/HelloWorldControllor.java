package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloWorldControllor {
    @RequestMapping("/HelloWorld")
    public String HelloWorld() {
        System.out.println("Hello World");
        return "Hello World!";
    }
}
