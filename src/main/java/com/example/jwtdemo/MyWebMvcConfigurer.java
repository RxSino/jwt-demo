package com.example.jwtdemo;

import com.example.jwtdemo.jwt.JWTTokenInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    @Bean
    public JWTTokenInterceptor jwtTokenInterceptor() {
        return new JWTTokenInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        /* check */
        //registry.addInterceptor(new CheckInterceptor()).addPathPatterns("/**");

        /* token */
        registry.addInterceptor(jwtTokenInterceptor()).addPathPatterns("/**");

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        /* resource */
        // registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");

    }



}
