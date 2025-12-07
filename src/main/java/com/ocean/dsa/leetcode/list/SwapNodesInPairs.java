package com.ocean.dsa.leetcode.list;

import com.ocean.dsa.leetcode.factory.ListNodeFactory;
import com.ocean.dsa.leetcode.model.ListNode;

public class SwapNodesInPairs {

    // ---------- LeetCode 24: Swap Nodes in Pairs ----------
    public static ListNode swapPairs(ListNode head) {
        // 1. Create a dummy node and point it to head
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 2. prev will always point to the node BEFORE the pair we're swapping
        ListNode prev = dummy;

        // 3. Loop while there are at least two nodes ahead to swap
        while (prev.next != null && prev.next.next != null) {
            // Identify the two nodes to swap
            ListNode first = prev.next;        // first node of the pair
            ListNode second = prev.next.next;  // second node of the pair

            // Save the node after the pair
            ListNode nextPair = second.next;

            // Perform the swap: prev -> second -> first -> nextPair
            second.next = first;       // second now points to first
            first.next = nextPair;     // first now points to the rest of the list
            prev.next = second;        // previous node now points to second (new first in pair)

            // Move prev to the end of the swapped pair (which is 'first' now)
            prev = first;
        }

        // Return the new head (dummy.next)
        return dummy.next;
    }

    public static void main(String[] args) {

        // ----------- TEST CASES -----------

        ListNode h1 = ListNodeFactory.buildList(new int[]{1, 2, 3, 4});
        System.out.print("Test 1 (expected: 2 -> 1 -> 4 -> 3): ");
        ListNodeFactory.printList(swapPairs(h1));

        ListNode h2 = ListNodeFactory.buildList(new int[]{1});
        System.out.print("Test 2 (expected: 1): ");
        ListNodeFactory.printList(swapPairs(h2));

        ListNode h3 = ListNodeFactory.buildList(new int[]{});
        System.out.print("Test 3 (expected: empty): ");
        ListNodeFactory.printList(swapPairs(h3));

        ListNode h4 = ListNodeFactory.buildList(new int[]{1, 2, 3});
        System.out.print("Test 4 (expected: 2 -> 1 -> 3): ");
        ListNodeFactory.printList(swapPairs(h4));

        ListNode h5 = ListNodeFactory.buildList(new int[]{10, 20, 30, 40, 50, 60});
        System.out.print("Test 5 (expected: 20 -> 10 -> 40 -> 30 -> 60 -> 50): ");
        ListNodeFactory.printList(swapPairs(h5));
    }

}