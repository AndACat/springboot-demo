package com.javatoai.business;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;
import java.math.RoundingMode;

@SpringBootApplication(scanBasePackages = "com.javatoai.business")
@MapperScan("com.javatoai.business.mapper")
@Slf4j
public class SpringBootDemoBusinessApplication {

    public static void main(String[] args) {
        try {
            long startTime = System.currentTimeMillis();
            // 设置代理服务器
//            System.setProperty("http.proxyHost", "localhost");
//            System.setProperty("http.proxyPort", "8866");
//            System.setProperty("https.proxyHost", "localhost");
//            System.setProperty("https.proxyPort", "8866");

            ApplicationContext context = SpringApplication.run(SpringBootDemoBusinessApplication.class, args);
            String nacosServerAddr = context.getEnvironment().getProperty("spring.cloud.nacos.config.server-addr");
            System.out.println("Nacos Server Address: " + nacosServerAddr);
            long endTime = System.currentTimeMillis();
            log.info("启动成功, 耗时: {}", BigDecimal.valueOf(startTime - endTime).divide(BigDecimal.valueOf(1000), 2, RoundingMode.HALF_UP));
        }catch (Throwable e) {
            log.error("启动失败", e);
        }
    }
}
