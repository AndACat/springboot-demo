package com.example.springdemo.config;

import com.example.springdemo.interceptor.UserIdHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
//@Import({CatActionService.class, UserIdHandlerInterceptor.class})
public class MyWebMvcConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserIdHandlerInterceptor()).addPathPatterns("/**");
    }
}
