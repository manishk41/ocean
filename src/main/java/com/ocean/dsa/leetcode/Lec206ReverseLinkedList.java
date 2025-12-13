package com.ocean.dsa.leetcode;

import com.ocean.factory.ListNodeFactory;
import com.ocean.model.ListNode;

public class Lec206ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;     // previous node (starts as null)
        ListNode curr = head;     // current node we are processing

        while (curr != null) {
            ListNode nextNode = curr.next;  // store next node
            curr.next = prev;               // reverse the link
            prev = curr;                    // move prev forward
            curr = nextNode;                // move curr forward
        }

        // prev is new head after loop ends
        return prev;
    }

    public static void main(String[] args) {
        Lec206ReverseLinkedList obj = new Lec206ReverseLinkedList();

        // ----------- TEST CASES -----------

        // Case 1: General list
        ListNode l1 = ListNodeFactory.buildList(new int[]{1, 2, 3, 4, 5});
        System.out.print("Test 1 (expected: 5 -> 4 -> 3 -> 2 -> 1): ");
        ListNodeFactory.printList(obj.reverseList(l1));

        // Case 2: Two nodes
        ListNode l2 = ListNodeFactory.buildList(new int[]{1, 2});
        System.out.print("Test 2 (expected: 2 -> 1): ");
        ListNodeFactory.printList(obj.reverseList(l2));

        // Case 3: Single node
        ListNode l3 = ListNodeFactory.buildList(new int[]{7});
        System.out.print("Test 3 (expected: 7): ");
        ListNodeFactory.printList(obj.reverseList(l3));

        // Case 4: Empty list
        ListNode l4 = null;
        System.out.print("Test 4 (expected: empty): ");
        ListNodeFactory.printList(obj.reverseList(l4));

        // Case 5: Long list
        ListNode l5 = ListNodeFactory.buildList(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1});
        System.out.print("Test 5 (expected: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9): ");
        ListNodeFactory.printList(obj.reverseList(l5));
    }

}