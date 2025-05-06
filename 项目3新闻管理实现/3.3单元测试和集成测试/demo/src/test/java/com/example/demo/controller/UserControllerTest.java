package com.example.demo.controller;

import com.example.demo.serviceImpl.UserServiceImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("junit5单元测试")
@ExtendWith(MockitoExtension.class)
class UserControllerTest {
    //    @InjectMocks注解用于将模拟对象注入到被测试对象中，以便在测试过程中使用模拟对象替代真实的对象进行测试
    @InjectMocks
    UserServiceImpl userServiceImpl;
    @DisplayName("测试输出")
    @Test
    public void test() {
        System.out.println("小李=====");
    }

    @DisplayName("测试UserServiceImpl中的fact()方法")
    @Test
    public void testFact(){
        assertEquals(2,userServiceImpl.fact(1));
        assertEquals(5,userServiceImpl.fact(3));
    }

    @BeforeEach
    void setUp() {
        System.out.println("BeforeEach=====");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("BeforeAll=====");
    }

    @AfterEach
    void tearDown() {
        System.out.println("AfterEach=====");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("AfterAll=====");
    }
}