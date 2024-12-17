package com.example.ratelimiter.fixedwindow.services;

import java.util.concurrent.atomic.AtomicInteger;

public class RateLimiterServiceImpl implements RateLimiter {

    private final int threshold;
    private volatile long windowStartTime;
    private final long windowUnit = 10000L;
    private final AtomicInteger counter = new AtomicInteger();

    /**
     * Constructs a RateLimiterServiceImpl with the specified threshold.
     * @param threshold the maximum number of requests allowed per window
     */
    public RateLimiterServiceImpl(int threshold) {
        this.threshold = threshold;
        this.windowStartTime = System.currentTimeMillis();
        System.out.println("Fresh Window Initialized at : "+windowStartTime);
    }

    @Override
    public boolean tryAcquire() {
        long currentTimeMillis = System.currentTimeMillis();

        //Below if is to start a new fixed window
        if (currentTimeMillis - windowStartTime >= windowUnit) {
            synchronized (RateLimiterServiceImpl.class) {
                // Double-check to prevent race condition issues in a multi-threaded environment.
                if (currentTimeMillis - windowStartTime >= windowUnit) {
                    counter.set(0);
                    windowStartTime = System.currentTimeMillis();
                }
            }
        }

        // Increment the counter and check if it exceeds the threshold.
        // If the counter is within the threshold, grant access; otherwise, reject the request.
        return counter.incrementAndGet() <= threshold;
    }
}
