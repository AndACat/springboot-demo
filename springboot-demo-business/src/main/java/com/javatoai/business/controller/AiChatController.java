package com.javatoai.business.controller;

import lombok.AllArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
@RequestMapping("/ai")
public class AiChatController {
    @Autowired
    private ChatClient chatClient;

    @GetMapping("/chat")
    public String generation(String userInput) {
        ChatClient.CallResponseSpec call = this.chatClient
                .prompt()
                .user(userInput)
                .call();
        return call.content();
    }
}
