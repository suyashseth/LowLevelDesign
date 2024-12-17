package com.example.ratelimiter.fixedwindow.controller;

import com.example.ratelimiter.fixedwindow.services.RateLimiter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimiterController {


    private final RateLimiter rateLimiter;

    public RateLimiterController(RateLimiter rateLimiter) {
        this.rateLimiter = rateLimiter;
    }

    @GetMapping("/hello")
    public ResponseEntity<Object> hello() {
        if (Boolean.FALSE.equals(rateLimiter.tryAcquire())) {
            return ResponseEntity.status(429).body("Too many request");
        }
        return ResponseEntity.accepted().body("Request Processed Successfully");
    }



}
