package com.example.springdemo.config;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import redis.embedded.RedisServer;
import java.io.IOException;
@Profile("none")
@Configuration
public class EmbeddedRedisConfig {

    private RedisServer redisServer;

    @Bean
    public RedisServer redisServer() throws IOException {
        redisServer = new RedisServer(6379); // 默认端口 6379
        redisServer.start();
        return redisServer;
    }

    /**
     * Spring Boot 关闭时执行 @PreDestroy 方法
     * 关闭 Redis
     */
    @PreDestroy
    public void stopRedis() {
        if (redisServer != null) {
            redisServer.stop();
        }
    }
}

