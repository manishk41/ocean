package com.ocean.multithreading.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {

    private static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) throws Exception {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.incrementAndGet();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.incrementAndGet();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Count: " + counter.get());

    }
}

// Real-world Use Cases
//1. Rate Limiter (like LeetCode 359 Logger Rate Limiter)
//AtomicInteger requests = new AtomicInteger();
//
//if (requests.incrementAndGet() > LIMIT_PER_SECOND) {
//        // reject request
//        }
