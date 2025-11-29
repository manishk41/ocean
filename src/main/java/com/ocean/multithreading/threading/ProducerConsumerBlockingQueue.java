package com.ocean.multithreading.threading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerBlockingQueue {

    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

        // Producer Thread
        Thread producer = new Thread(new Producer(queue));
        // Consumer Thread
        Thread consumer = new Thread(new Consumer(queue));

        producer.start();
        consumer.start();
    }
}

// PRODUCER
class Producer implements Runnable {

    private final BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int value = 0;
        try {
            while (true) {
                System.out.println("Producing " + value);
                queue.put(value);    // waits if queue is full
                value++;
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

// CONSUMER
class Consumer implements Runnable {

    private final BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Integer val = queue.take(); // waits if queue is empty
                System.out.println("Consuming " + val);
                Thread.sleep(1500);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

// BlockingQueue is a thread-safe queue that blocks a thread when the queue is:
// Full → Producer waits
// Empty → Consumer waits
// It is mainly used in Producer–Consumer systems.

// Why BlockingQueue?
// Without it, you would need to use:
//  - wait()/notify()
//  - manual synchronized blocks
//    → error-prone and interviewers want cleaner solutions.
// BlockingQueue provides automatic locking + thread coordination.

// Blocking put/take
// Non-blocking offer/poll


// BlockingQueue handles thread synchronization internally.
// put() → waits if queue is full (blocking).
// take() → waits if queue is empty (blocking).
// No need for wait(), notify(), or manual locks.

// Q. Why BlockingQueue?
// - Thread-safe
// - Handles blocking internally
// - No need to manage synchronization
// - Cleaner and production-grade solution

// Q. How backpressure works?
// - When queue is full → producer blocks
// - When queue is empty → consumer blocks
// This prevents memory overflow and ensures smooth processing.