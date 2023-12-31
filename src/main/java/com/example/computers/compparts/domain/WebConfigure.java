package com.example.computers.compparts.domain;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfigure implements WebMvcConfigurer {
    @Override
    public void addViewControllers (ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("homepage");
    }
}
