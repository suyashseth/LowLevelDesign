package com.example.ratelimiter.fixedwindow.services;

public interface RateLimiter {

    boolean tryAcquire();

}
