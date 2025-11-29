package com.ocean.multithreading.threading;

public class ThreadStatesDemo {

    private static final Object lock = new Object();

    static class MyTask implements Runnable {
        @Override
        public void run() {
            try {
                // TIMED_WAITING
                Thread.sleep(500);

                // WAITING
                synchronized (lock) {
                    lock.wait(500); // goes to WAITING or TIMED_WAITING depending on timing
                }

            } catch (Exception ignored) {}
        }
    }

    public static void main(String[] args) throws Exception {

        Thread t = new Thread(new MyTask(), "MyThread");
        System.out.println("State after creation: " + t.getState()); // NEW

        t.start();
        Thread.sleep(100);
        System.out.println("State after start(): " + t.getState()); // RUNNABLE or TIMED_WAITING

        // TIMED_WAITING (sleep)
        Thread.sleep(300);
        System.out.println("State (during sleep inside run): " + t.getState()); // TIMED_WAITING

        // BLOCKED (waiting for lock)
        Thread blockedThread = new Thread(() -> {
            synchronized (lock) { }
        }, "BlockedThread");

        synchronized (lock) {
            blockedThread.start();
            Thread.sleep(100);
            System.out.println("State of BlockedThread: " + blockedThread.getState()); // BLOCKED
        }

        // WAITING (wait())
        Thread waitingThread = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait(); // WAITING
                } catch (Exception ignored) {}
            }
        }, "WaitingThread");

        waitingThread.start();
        Thread.sleep(200);
        System.out.println("State of WaitingThread: " + waitingThread.getState()); // WAITING

        synchronized (lock) {
            lock.notify();  // move from WAITING to RUNNABLE
        }
        Thread.sleep(100);

        // TERMINATED
        Thread.sleep(2000);
        System.out.println("Final state of MyThread: " + t.getState()); // TERMINATED
    }
}
