package com.example.springdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.springdemo")
@MapperScan("com.example.springdemo.mapper")
public class SpringBootDemoBusinessApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoBusinessApplication.class, args);
    }

}
