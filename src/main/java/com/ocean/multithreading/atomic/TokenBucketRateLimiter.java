package com.ocean.multithreading.atomic;

import java.util.concurrent.atomic.AtomicLong;

public class TokenBucketRateLimiter {

    private final long capacity;             // max tokens
    private final long refillRatePerSecond;  // tokens/sec
    private final AtomicLong availableTokens;
    private final AtomicLong lastRefillTimestamp;

    public TokenBucketRateLimiter(long capacity, long refillRatePerSecond) {
        this.capacity = capacity;
        this.refillRatePerSecond = refillRatePerSecond;
        this.availableTokens = new AtomicLong(capacity);
        this.lastRefillTimestamp = new AtomicLong(System.nanoTime());
    }

    public boolean allowRequest() {
        refillTokens();                             // Step 1: update bucket before checking
        long tokensLeft = availableTokens.get();

        if (tokensLeft > 0) {                       // Step 2: if token available
            return availableTokens.compareAndSet(tokensLeft, tokensLeft - 1);
        }
        return false;                               // Step 3: no token → reject
    }

    private void refillTokens() {
        // Step 1: Calculate time passed
        long now = System.nanoTime();
        long lastRefill = lastRefillTimestamp.get();
        long elapsedNanos = now - lastRefill;

        // Step 2: Compute tokens to add
        long tokensToAdd = (elapsedNanos * refillRatePerSecond) / 1_000_000_000L;
        // eg. refillRatePerSecond = 5 tokens/second.
        // If 200ms passed, 200ms = 0.2 sec → 5 * 0.2 = 1 token to add

        if (tokensToAdd > 0) {
            long newLastRefill = lastRefill + (tokensToAdd * 1_000_000_000L / refillRatePerSecond);

            // Step 3: Update the lastRefillTimestamp (thread safe)
            if (lastRefillTimestamp.compareAndSet(lastRefill, newLastRefill)) {
                long oldTokens;
                long newTokens;

                // Step 4: Add tokens (thread-safe)
                do {
                    oldTokens = availableTokens.get();
                    newTokens = Math.min(capacity, oldTokens + tokensToAdd);
                } while (!availableTokens.compareAndSet(oldTokens, newTokens));
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TokenBucketRateLimiter limiter = new TokenBucketRateLimiter(5, 1); // 5 tokens, 1 token/sec

        for (int i = 0; i < 10; i++) {
            System.out.println("Request " + i + " Allowed? " + limiter.allowRequest());
            Thread.sleep(100);
        }
    }
}

// How Token Bucket Works:
// - You have a bucket with a fixed capacity (max tokens).
// - Tokens refill at a fixed rate (e.g., 1 token per second).
// - Each incoming request needs 1 token.
// - If bucket has ≥1 token → request allowed
// - If bucket is empty → reject (rate limit hit)
