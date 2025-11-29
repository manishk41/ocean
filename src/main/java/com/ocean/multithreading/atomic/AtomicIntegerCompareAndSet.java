package com.ocean.multithreading.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerCompareAndSet {

    public static void main(String[] args) throws Exception {

        // Compare-And-Set (CAS)
        AtomicInteger ai = new AtomicInteger(10);

        boolean success = ai.compareAndSet(10, 15);

        System.out.println(success); // true
        System.out.println(ai.get()); // 15

    }
}