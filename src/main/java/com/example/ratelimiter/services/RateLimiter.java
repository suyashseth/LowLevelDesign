package com.example.ratelimiter.services;

public interface RateLimiter {

    boolean tryAcquire();

}
