package com.ocean.dsa.leetcode;

import com.ocean.model.ListNode;

import java.util.*;

import static com.ocean.factory.ListNodeFactory.buildList;
import static com.ocean.factory.ListNodeFactory.printList;

public class Lec23MergekSortedLists {

    // ---------- LeetCode 23: Merge K Sorted Lists ----------
    public static ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> pq =
                new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

        // Add initial heads
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (!pq.isEmpty()) {
            ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next;

            if (min.next != null) {
                pq.offer(min.next);
            }
        }

        return dummy.next;
    }


    public static void main(String[] args) {
        // ----------- TEST CASES -----------

        // Case 1
        ListNode[] lists1 = new ListNode[]{
                buildList(new int[]{1,4,5}),
                buildList(new int[]{1,3,4}),
                buildList(new int[]{2,6})
        };
        System.out.print("Test 1 (expected: 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6): ");
        printList(mergeKLists(lists1));

        // Case 2: empty array
        ListNode[] lists2 = new ListNode[]{};
        System.out.print("Test 2 (expected: empty): ");
        printList(mergeKLists(lists2));

        // Case 3: array with empty lists
        ListNode[] lists3 = new ListNode[]{
                null,
                buildList(new int[]{1}),
                null
        };
        System.out.print("Test 3 (expected: 1): ");
        printList(mergeKLists(lists3));

        // Case 4: single list
        ListNode[] lists4 = new ListNode[]{
                buildList(new int[]{5,7,9})
        };
        System.out.print("Test 4 (expected: 5 -> 7 -> 9): ");
        printList(mergeKLists(lists4));
    }

}