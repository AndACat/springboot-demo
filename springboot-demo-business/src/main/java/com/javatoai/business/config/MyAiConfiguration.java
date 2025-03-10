package com.javatoai.business.config;

import com.javatoai.business.utils.ApplicationContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 */
@Configuration
@Slf4j
public class MyAiConfiguration {
    private final String defaultSystem = """
            你是一个很厉害的软件工程师，精通java,python,cpp,c,javascript,html,css等语言的开发,
                如果接下来用户问你一些问题，请你以专业的角度和话语，回答用户的问题。并在回答之前，给出思考过程。
            """;
    @Bean
    public ChatClient chatClient(ChatClient.Builder builder) {
        return builder.defaultSystem("""
                1+1等于多少
                """)
                .build();
    }

    @Bean
    public CommandLineRunner runner(ChatClient chatClient) {
        return args -> {
//            String response = chatClient.prompt("请给我说一个大笑话 哈哈哈").call().content();
//            log.info("说出的笑话内容: {}", response);
        };
    }
    @Bean
    public CommandLineRunner print(){
        return args -> {
            ChatModel chatModel = ApplicationContextUtil.APPLICATION_CONTEXT.getBean(ChatModel.class);
            log.info("load chatModel: {}", chatModel.getClass().getName());
        };
    }
}
