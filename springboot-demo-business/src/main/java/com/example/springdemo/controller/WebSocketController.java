package com.example.springdemo.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@MessageMapping("/app")
public class WebSocketController {

    @MessageMapping("/hello") // 映射客户端发送到 /app/hello 的消息
    @SendTo("/topic/greetings") // 将消息发送到 /topic/greetings
    public String greeting(String message) throws Exception {
        // 在这里可以进行业务逻辑处理
        return "Hello, " + message + "!";
    }
}
