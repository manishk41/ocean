package com.ocean.leetcode.design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private final int capacity;
    private final Map<Integer, Node> map = new HashMap<>();
    private final Node head = new Node(0, 0); // dummy head
    private final Node tail = new Node(0, 0); // dummy tail

    static class Node {
        int key, value;
        Node prev, next;
        Node(int k, int v) { key = k; value = v; }
    }

    public LRUCache(int capacity) {
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
        if (!map.containsKey(key)) return -1;

        Node node = map.get(key);
        remove(node);
        insertToFront(node);
        return node.value;
    }

    public void put(int key, int value) {

        // update existing node
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            remove(node);
            insertToFront(node);
            return;
        }

        // evict if full
        if (map.size() == capacity) {
            Node lru = tail.prev;
            remove(lru);
            map.remove(lru.key);
        }

        // insert new node
        Node node = new Node(key, value);
        insertToFront(node);
        map.put(key, node);
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);

        lruCache.put(1, 1);
        lruCache.put(2, 2);

        System.out.println("Proper Test 1 get(1) expected=1: " + lruCache.get(1));

        lruCache.put(3, 3);  // evicts 2

        System.out.println("Proper Test 2 get(2) expected=-1: " + lruCache.get(2));

        lruCache.put(4, 4);  // evicts 1

        System.out.println("Proper Test 3 get(1) expected=-1: " + lruCache.get(1));
        System.out.println("Proper Test 4 get(3) expected=3: " + lruCache.get(3));
        System.out.println("Proper Test 5 get(4) expected=4: " + lruCache.get(4));
    }

}