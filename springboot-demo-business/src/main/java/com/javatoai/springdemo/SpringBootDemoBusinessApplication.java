package com.javatoai.springdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(scanBasePackages = "com.javatoai.springdemo")
@MapperScan("com.javatoai.springdemo.mapper")
public class SpringBootDemoBusinessApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringBootDemoBusinessApplication.class, args);
        String nacosServerAddr = context.getEnvironment().getProperty("spring.cloud.nacos.config.server-addr");
        System.out.println("Nacos Server Address: " + nacosServerAddr);
    }

}
