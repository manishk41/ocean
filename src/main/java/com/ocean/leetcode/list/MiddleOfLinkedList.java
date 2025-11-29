package com.ocean.leetcode.list;

import com.ocean.leetcode.factory.ListNodeFactory;
import com.ocean.leetcode.model.ListNode;

public class MiddleOfLinkedList {

    public ListNode middleNode(ListNode head) {
        if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;        // 1 step
            fast = fast.next.next;   // 2 steps
        }

        return slow; // slow is at middle
    }

    public static void main(String[] args) {

        MiddleOfLinkedList obj = new MiddleOfLinkedList();

        // ----------- TEST CASES -----------

        // Case 1: odd length
        ListNode l1 = ListNodeFactory.buildList(new int[]{1, 2, 3, 4, 5});
        System.out.print("Test 1 (expected: 3): ");
        ListNodeFactory.printNode(obj.middleNode(l1));

        // Case 2: even length → return second middle
        ListNode l2 = ListNodeFactory.buildList(new int[]{1, 2, 3, 4, 5, 6});
        System.out.print("Test 2 (expected: 4): ");
        ListNodeFactory.printNode(obj.middleNode(l2));

        // Case 3: single node
        ListNode l3 = ListNodeFactory.buildList(new int[]{7});
        System.out.print("Test 3 (expected: 7): ");
        ListNodeFactory.printNode(obj.middleNode(l3));

        // Case 4: two nodes → return second
        ListNode l4 = ListNodeFactory.buildList(new int[]{10, 20});
        System.out.print("Test 4 (expected: 20): ");
        ListNodeFactory.printNode(obj.middleNode(l4));

        // Case 5: long list
        ListNode l5 = ListNodeFactory.buildList(new int[]{1,2,3,4,5,6,7,8,9,10});
        System.out.print("Test 5 (expected: 6): ");
        ListNodeFactory.printNode(obj.middleNode(l5));

        // Case 6: empty list
        System.out.print("Test 6 (expected: null): ");
        ListNodeFactory.printNode(obj.middleNode(null));
    }

}