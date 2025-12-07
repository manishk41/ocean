package com.ocean.multithreading.synchronization;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowRateLimiter {

    private final int maxRequests;
    private final long windowSizeInMillis;
    private final Deque<Long> requestTimestamps = new ArrayDeque<>();

    public SlidingWindowRateLimiter(int maxRequests, long windowSizeInMillis) {
        this.maxRequests = maxRequests;
        this.windowSizeInMillis = windowSizeInMillis;
    }

    public synchronized boolean allowRequest() {
        long now = System.currentTimeMillis();

        // remove timestamps outside the window
        while (!requestTimestamps.isEmpty() && now - requestTimestamps.peekFirst() >= windowSizeInMillis) {
            requestTimestamps.pollFirst();
        }

        if (requestTimestamps.size() < maxRequests) {
            requestTimestamps.addLast(now);
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws InterruptedException {
        SlidingWindowRateLimiter limiter = new SlidingWindowRateLimiter(5, 1000);

        for (int i = 0; i < 10; i++) {
            System.out.println("Request " + i + " Allowed? " + limiter.allowRequest());
            Thread.sleep(100);
        }
    }
}