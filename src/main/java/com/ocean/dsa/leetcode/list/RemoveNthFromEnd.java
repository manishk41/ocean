package com.ocean.dsa.leetcode.list;

import com.ocean.dsa.leetcode.factory.ListNodeFactory;
import com.ocean.dsa.leetcode.model.ListNode;

public class RemoveNthFromEnd {

    // ---------- LeetCode 19: Remove Nth Node From End ----------
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;

        // 1. Create a dummy node before head
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 2. Create two pointers slow and fast, starting at dummy
        ListNode fast = dummy;
        ListNode slow = dummy;

        // 3. Move fast N steps ahead
        for (int i = 0; i < n; i++) {
            if (fast.next == null) return head; // invalid n (greater than length)
            fast = fast.next;
        }

        // 4. Move both pointers until fast reaches the end
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 5. Now slow is just before the node to delete
        slow.next = slow.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {

        // CASE 1: remove 2nd from end
        ListNode h1 = ListNodeFactory.buildList(new int[]{1,2,3,4,5});
        System.out.print("Test 1 (expected: 1 -> 2 -> 3 -> 5): ");
        ListNodeFactory.printList(removeNthFromEnd(h1, 2));

        // CASE 2: remove last node
        ListNode h2 = ListNodeFactory.buildList(new int[]{1, 2});
        System.out.print("Test 2 (expected: 1): ");
        ListNodeFactory.printList(removeNthFromEnd(h2, 1));

        // CASE 3: remove head
        ListNode h3 = ListNodeFactory.buildList(new int[]{1, 2, 3});
        System.out.print("Test 3 (expected: 2 -> 3): ");
        ListNodeFactory.printList(removeNthFromEnd(h3, 3));

        // CASE 4: single node
        ListNode h4 = ListNodeFactory.buildList(new int[]{7});
        System.out.print("Test 4 (expected: empty): ");
        ListNodeFactory.printList(removeNthFromEnd(h4, 1));

        // CASE 5: invalid N > length (return unchanged or throw)
        ListNode h5 = ListNodeFactory.buildList(new int[]{9,8,7});
        System.out.print("Test 5 (expected: 9 -> 8 -> 7): ");
        ListNodeFactory.printList(removeNthFromEnd(h5, 5));

        // CASE 6: remove 1st from end (multiple values)
        ListNode h6 = ListNodeFactory.buildList(new int[]{10,20,30,40});
        System.out.print("Test 6 (expected: 10 -> 20 -> 30): ");
        ListNodeFactory.printList(removeNthFromEnd(h6, 1));
    }

}