package com.example.demo.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

    @Configuration
    @EnableWebMvc
    public class WebConfig_backup implements WebMvcConfigurer {

        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**")
                    .allowedOrigins("http://localhost:8080","http://localhost:8082", "http://localhost:5173", "https://webtech2024-frontend-1.onrender.com")
                    .allowedMethods("*")
                    .allowedHeaders("*")
                    .allowCredentials(true);
        }
    }

