package com.ocean.dsa.leetcode;

import com.ocean.factory.ListNodeFactory;
import com.ocean.model.ListNode;

public class Lec141LinkedListCycle {

    // ---------- LeetCode 141: Linked List Cycle ----------
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;           // move 1 step
            fast = fast.next.next;      // move 2 steps

            if (slow == fast) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Lec141LinkedListCycle obj = new Lec141LinkedListCycle();

        // ----------- TEST CASES -----------

        // Case 1: List with a cycle (pos = 1)
        ListNode c1 = ListNodeFactory.buildList(new int[]{3, 2, 0, -4});
        ListNodeFactory.createCycle(c1, 1); // cycle at index 1 (value = 2)
        System.out.println("Test 1 (expected: true): " + obj.hasCycle(c1));

        // Case 2: No cycle
        ListNode c2 = ListNodeFactory.buildList(new int[]{1, 2});
        System.out.println("Test 2 (expected: false): " + obj.hasCycle(c2));

        // Case 3: Single node with no cycle
        ListNode c3 = ListNodeFactory.buildList(new int[]{1});
        System.out.println("Test 3 (expected: false): " + obj.hasCycle(c3));

        // Case 4: Single node with cycle to itself
        ListNode c4 = ListNodeFactory.buildList(new int[]{1});
        ListNodeFactory.createCycle(c4, 0);
        System.out.println("Test 4 (expected: true): " + obj.hasCycle(c4));

        // Case 5: Larger cycle
        ListNode c5 = ListNodeFactory.buildList(new int[]{1, 2, 3, 4, 5});
        ListNodeFactory.createCycle(c5, 2); // cycle starts at node with value 3
        System.out.println("Test 5 (expected: true): " + obj.hasCycle(c5));

        // Case 6: Empty list
        System.out.println("Test 6 (expected: false): " + obj.hasCycle(null));
    }
}
