package com.ocean.dsa.leetcode.factory;

import com.ocean.dsa.leetcode.model.ListNode;

public class ListNodeFactory {

    // ---------- Build Linked List from Array ----------
    public static ListNode buildList(int[] arr) {
        if (arr == null || arr.length == 0) return null;

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        for (int n : arr) {
            curr.next = new ListNode(n);
            curr = curr.next;
        }
        return dummy.next;
    }

    // ---------- Print Linked List ----------
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    // ---------- Create Cycle at index 'pos' ----------
    // pos = -1 means NO cycle (like LeetCode)
    public static void createCycle(ListNode head, int pos) {
        if (pos < 0 || head == null) return;

        ListNode tail = head;
        ListNode cycleNode = null;

        int index = 0;
        while (tail.next != null) {
            if (index == pos) {
                cycleNode = tail;
            }
            tail = tail.next;
            index++;
        }

        if (index == pos) {
            cycleNode = tail; // last element
        }

        // link tail to cycleNode to form cycle
        tail.next = cycleNode;
    }

    // ---------- Print only the node value ----------
    public static void printNode(ListNode node) {
        if (node == null) {
            System.out.println("null");
            return;
        }
        System.out.println(node.val);
    }

}