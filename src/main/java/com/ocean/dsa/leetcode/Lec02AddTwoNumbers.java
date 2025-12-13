package com.ocean.dsa.leetcode;

import com.ocean.factory.ListNodeFactory;
import com.ocean.model.ListNode;

public class Lec02AddTwoNumbers {

    // ---------- LeetCode 2: Add Two Numbers ----------
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Lec02AddTwoNumbers obj = new Lec02AddTwoNumbers();

        // ----------- TEST CASES -----------

        // Case 1: Basic test
        ListNode l1 = ListNodeFactory.buildList(new int[]{2, 4, 3});
        ListNode l2 = ListNodeFactory.buildList(new int[]{5, 6, 4});
        System.out.print("Test 1 (expected: 7 -> 0 -> 8): ");
        ListNodeFactory.printList(obj.addTwoNumbers(l1, l2));

        // Case 2: Different lengths
        ListNode l3 = ListNodeFactory.buildList(new int[]{9, 9});
        ListNode l4 = ListNodeFactory.buildList(new int[]{1});
        System.out.print("Test 2 (expected: 0 -> 0 -> 1): ");
        ListNodeFactory.printList(obj.addTwoNumbers(l3, l4));

        // Case 3: One list is empty
        ListNode l5 = null;
        ListNode l6 = ListNodeFactory.buildList(new int[]{1, 2, 3});
        System.out.print("Test 3 (expected: 1 -> 2 -> 3): ");
        ListNodeFactory.printList(obj.addTwoNumbers(l5, l6));

        // Case 4: Both zeros
        ListNode l7 = ListNodeFactory.buildList(new int[]{0});
        ListNode l8 = ListNodeFactory.buildList(new int[]{0});
        System.out.print("Test 4 (expected: 0): ");
        ListNodeFactory.printList(obj.addTwoNumbers(l7, l8));

        // Case 5: Big carry chain
        ListNode l9 = ListNodeFactory.buildList(new int[]{9, 9, 9, 9});
        ListNode l10 = ListNodeFactory.buildList(new int[]{9, 9, 9, 9});
        System.out.print("Test 5 (expected: 8 -> 9 -> 9 -> 9 -> 1): ");
        ListNodeFactory.printList(obj.addTwoNumbers(l9, l10));
    }

}