package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		System.out.println("=====before Spring Boot=====");
		SpringApplication.run(DemoApplication.class, args);
		int sum = 0, i = 0;
		while (sum < 2000) {
			System.out.println("i = " + i + "，sum = " + sum);
			System.out.println(Calculate.sum(1,2));
			sum += i++;
		}
	}

}
