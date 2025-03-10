package com.javatoai.business.config;

import com.javatoai.business.utils.ApplicationContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.client.RestClient;

import java.util.Arrays;

/**
 *
 */
@Configuration
@Slf4j
public class SpringConfiguration {

    @Bean
    @Order(Integer.MIN_VALUE)
    public ApplicationContextAware contextAware(){
        return context -> {
            ApplicationContextUtil.APPLICATION_CONTEXT = context;
            ApplicationContextUtil.PROFILE_LIST = Arrays.stream(context.getEnvironment().getActiveProfiles()).toList();
        };
    }
    @Autowired(required = false)
    RestClient.Builder restClientBuilder;


//    @Bean
//    public NacosConfigProperties nacosConfigProperties(){
//        com.alibaba.cloud.nacos.NacosConfigProperties nacosConfigProperties = new com.alibaba.cloud.nacos.NacosConfigProperties();
//        nacosConfigProperties.setServerAddr("192.168.100.200:8848");
//        com.alibaba.cloud.nacos.NacosConfigProperties nacosConfigProperties1 = new com.alibaba.cloud.nacos.NacosConfigProperties();
//        return nacosConfigProperties;
//    }
}
