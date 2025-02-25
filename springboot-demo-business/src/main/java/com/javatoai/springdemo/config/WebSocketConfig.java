package com.javatoai.springdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    @Autowired
    @Qualifier("chatSocketHandler")
    private WebSocketHandler chatSocketHandler;

    @Autowired
    @Qualifier("aiSocketHandler")
    private WebSocketHandler aiSocketHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {

        registry
                .addHandler(chatSocketHandler, "/ws/chat") // 使用apifox进行测试连接的地址为: ws://localhost:12000/ws/chat
                .addHandler(aiSocketHandler, "/ws/ai") // 使用apifox进行测试连接的地址为: ws://localhost:12000/ws/ai
                .setAllowedOrigins("*");
    }

    @Bean
    public ServletServerContainerFactoryBean createWebSocketContainer() {
        ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean();
        // 消息缓冲区大小的大小
        container.setMaxTextMessageBufferSize(8192);
        container.setMaxBinaryMessageBufferSize(8192);
        return container;
    }
}
