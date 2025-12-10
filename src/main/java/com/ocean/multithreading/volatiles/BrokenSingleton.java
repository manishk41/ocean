package com.ocean.multithreading.volatiles;

public class BrokenSingleton {

    private static volatile BrokenSingleton instance;

    private int value;

    private BrokenSingleton() {
        // Simulate heavy initialization
        try { Thread.sleep(10); } catch (Exception ignored) {}
        value = 42;
    }

    public static BrokenSingleton getInstance() {
        if (instance == null) {
            synchronized (BrokenSingleton.class) {
                if (instance == null) {
                    instance = new BrokenSingleton(); // NO volatile → reordering
                }
            }
        }
        return instance;
    }

    public int getValue() {
        return value;
    }

    public static void main(String[] args) throws Exception {

        Runnable task = () -> {
            BrokenSingleton s = BrokenSingleton.getInstance();

            if (s.getValue() != 42) {  // partially constructed!
                System.out.println("BROKEN: Saw uninitialized value: " + s.getValue());
            }
        };

        Thread[] threads = new Thread[50];

        for (int i = 0; i < 50; i++) {
            threads[i] = new Thread(task);
        }

        for (Thread t : threads) t.start();
        for (Thread t : threads) t.join();

        System.out.println("Done Testing Broken Singleton");
    }
}