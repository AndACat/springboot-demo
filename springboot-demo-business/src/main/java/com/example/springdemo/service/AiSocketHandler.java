package com.example.springdemo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;

/**
 * <h2>测试 - socket连接处理器</h2>
 */
@Component(value = "aiSocketHandler")
@Slf4j
public class AiSocketHandler implements WebSocketHandler {

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.info("Test Socket 连接成功，sessionId：{}", session.getId());
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        if (message instanceof TextMessage) {
            final String msg = ((TextMessage)message).getPayload();
            log.info("Test Socket 收到消息：{}", msg);
        } else {
            log.error("Test Socket 消息处理失败，只接受 文本消息，sessionId：{}", session.getId());
        }
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        log.error("Test Socket 处理异常，sessionId：{}, 异常原因：{}", session.getId(), exception.getMessage());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        log.info("Test Socket 关闭，sessionId：{}", session.getId());
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
