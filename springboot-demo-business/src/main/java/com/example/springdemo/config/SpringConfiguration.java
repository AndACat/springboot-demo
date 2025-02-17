package com.example.springdemo.config;

import com.example.springdemo.utils.ApplicationContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 *
 */
@Configuration
@Slf4j
public class SpringConfiguration {
    @Bean
    public ChatClient chatClient(ChatClient.Builder builder) {
        return builder.defaultSystem("""
                你是一个很厉害的软件工程师，精通java,python,cpp,c,javascript,html,css等语言的开发,
                如果接下来用户问你一些问题，请你以专业的角度和话语，回答用户的问题。并在回答之前，给出思考过程。
                """).build();
    }

    @Bean
    public CommandLineRunner runner(ChatClient chatClient) {
        return args -> {
//            String response = chatClient.prompt("请给我说一个大笑话 哈哈哈").call().content();
//            log.info("说出的笑话内容: {}", response);
        };
    }

    @Bean
    public ApplicationContextAware contextAware(){
        return context -> {
            ApplicationContextUtil.APPLICATION_CONTEXT = context;
            ApplicationContextUtil.PROFILE_LIST = Arrays.stream(context.getEnvironment().getActiveProfiles()).toList();
        };
    }
}
