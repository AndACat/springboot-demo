package com.javatoai.clickhouse;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;
import java.math.RoundingMode;

@SpringBootApplication(
        scanBasePackages = "com.javatoai.clickhouse",
        exclude = {
                DataSourceAutoConfiguration.class,
                DataSourceTransactionManagerAutoConfiguration.class
        })
@MapperScan("com.javatoai.clickhouse.mapper")
@Slf4j
public class SpringBootDemoClickhouseApplication {

    public static void main(String[] args) {
        try {
            long startTime = System.currentTimeMillis();
            ApplicationContext context = SpringApplication.run(SpringBootDemoClickhouseApplication.class, args);
            long endTime = System.currentTimeMillis();
            log.info("启动成功, 耗时: {}秒", BigDecimal.valueOf(endTime - startTime).divide(BigDecimal.valueOf(1000), 2, RoundingMode.HALF_UP));
        }catch (Throwable e) {
            log.error("启动失败", e);
        }
    }
}
