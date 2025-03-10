package com.javatoai.clickhouse.configuration;

import com.javatoai.clickhouse.IActionService;
import com.javatoai.clickhouse.service.DogActionService;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

/**
 *
 */
@AutoConfiguration
public class MyDemoAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "actionService", name = "enableAction", havingValue = "dogActionService", matchIfMissing = false)
    public IActionService dogActionService() {
        return new DogActionService();
    }
}
