package com.ocean.dsa.leetcode;

import com.ocean.model.ListNode;

import static com.ocean.factory.ListNodeFactory.buildList;
import static com.ocean.factory.ListNodeFactory.printList;

public class Lec21MergeTwoSortedLists {

    // ---------- LeetCode 21: Merge Two Sorted Lists ----------
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        // attach remaining nodes
        curr.next = (l1 != null) ? l1 : l2;

        return dummy.next;
    }

    public static void main(String[] args) {
        // ----------- TEST CASES -----------
        ListNode l1 = buildList(new int[]{1,2,4});
        ListNode l2 = buildList(new int[]{1,3,4});
        System.out.print("Test 1 (expected: 1 -> 1 -> 2 -> 3 -> 4 -> 4): ");
        printList(mergeTwoLists(l1, l2));

        ListNode l3 = buildList(new int[]{});
        ListNode l4 = buildList(new int[]{});
        System.out.print("Test 2 (expected: empty): ");
        printList(mergeTwoLists(l3, l4));

        ListNode l5 = buildList(new int[]{});
        ListNode l6 = buildList(new int[]{0});
        System.out.print("Test 3 (expected: 0): ");
        printList(mergeTwoLists(l5, l6));

        ListNode l7 = buildList(new int[]{2,5,7});
        ListNode l8 = buildList(new int[]{1,3,6,8});
        System.out.print("Test 4 (expected: 1 -> 2 -> 3 -> 5 -> 6 -> 7 -> 8): ");
        printList(mergeTwoLists(l7, l8));
    }

}