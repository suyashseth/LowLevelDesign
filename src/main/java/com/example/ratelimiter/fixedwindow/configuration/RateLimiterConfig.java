package com.example.ratelimiter.fixedwindow.configuration;

import com.example.ratelimiter.fixedwindow.services.RateLimiter;
import com.example.ratelimiter.fixedwindow.services.RateLimiterServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Configuration
@Component
public class RateLimiterConfig {

    @Bean
    public RateLimiter rateLimitInitializer() {
        return new RateLimiterServiceImpl(10);
    }

}
