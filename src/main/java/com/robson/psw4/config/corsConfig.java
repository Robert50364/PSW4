package com.robson.psw4.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class corsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                .allowedOriginPatterns("http://localhost**")
                .allowedOrigins("http://localhost:5173")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS")
                .allowedHeaders("Access-Control-Allow-Origin", "Content-Type", "Accept", "Authorization", "authorization")
                .allowedHeaders("cross-origin-resource-policy")
                .allowCredentials(true);
    }
}
