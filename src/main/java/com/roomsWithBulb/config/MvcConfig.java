package com.roomsWithBulb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("static/**")
                .addResourceLocations("classpath:/static/");
        registry.addResourceHandler("db/**")
                .addResourceLocations("classpath:/db/");
    }
}
