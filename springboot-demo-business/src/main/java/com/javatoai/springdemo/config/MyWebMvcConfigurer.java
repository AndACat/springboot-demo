package com.javatoai.springdemo.config;

import com.javatoai.springdemo.interceptor.UserIdHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
//@Import({CatActionService.class, UserIdHandlerInterceptor.class})
public class MyWebMvcConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserIdHandlerInterceptor()).addPathPatterns("/**");
    }
}
