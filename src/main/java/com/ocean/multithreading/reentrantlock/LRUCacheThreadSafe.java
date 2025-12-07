package com.ocean.multithreading.reentrantlock;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class LRUCacheThreadSafe {

    private final int capacity;
    private final Map<Integer, Node> map = new HashMap<>();
    private final Node head = new Node(0, 0); // dummy head
    private final Node tail = new Node(0, 0); // dummy tail

    private final ReentrantLock lock = new ReentrantLock();

    static class Node {
        int key, value;
        Node prev, next;
        Node(int k, int v) { key = k; value = v; }
    }

    public LRUCacheThreadSafe(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertToFront(Node node) {
        Node next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
    }

    public int get(int key) {
        lock.lock();
        try {
            if (!map.containsKey(key)) return -1;

            Node node = map.get(key);
            remove(node);
            insertToFront(node);

            return node.value;
        } finally {
            lock.unlock();
        }
    }

    public void put(int key, int value) {
        lock.lock();
        try {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                node.value = value;
                remove(node);
                insertToFront(node);
                return;
            }

            if (map.size() == capacity) {
                Node lru = tail.prev;
                remove(lru);
                map.remove(lru.key);
            }

            Node node = new Node(key, value);
            insertToFront(node);
            map.put(key, node);
        } finally {
            lock.unlock();
        }
    }

    // For debugging after multi-threaded operations
    public void printState() {
        lock.lock();
        try {
            Node curr = head.next;
            while (curr != tail) {
                System.out.print("[" + curr.key + "=" + curr.value + "] ");
                curr = curr.next;
            }
            System.out.println();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        System.out.println("=== THREAD-SAFE LRU TEST ===");

        final int THREADS = 20;
        final int OPERATIONS = 5000;

        LRUCacheThreadSafe cache = new LRUCacheThreadSafe(5);

        ExecutorService executor = Executors.newFixedThreadPool(THREADS);
        AtomicInteger putCount = new AtomicInteger(0);
        AtomicInteger getCount = new AtomicInteger(0);

        for (int t = 0; t < THREADS; t++) {
            executor.submit(() -> {
                Random random = new Random();

                for (int i = 0; i < OPERATIONS; i++) {

                    int key = random.nextInt(10);   // keys 0–9
                    int val = random.nextInt(100);  // random value

                    if (random.nextBoolean()) {
                        cache.put(key, val);
                        putCount.incrementAndGet();
                    } else {
                        cache.get(key);
                        getCount.incrementAndGet();
                    }
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);

        System.out.println("\n=== STRESS TEST COMPLETED ===");
        System.out.println("Total PUT operations: " + putCount.get());
        System.out.println("Total GET operations: " + getCount.get());
        System.out.println("Final LRU Cache State (Most→Least Recent):");

        cache.printState();
    }

}