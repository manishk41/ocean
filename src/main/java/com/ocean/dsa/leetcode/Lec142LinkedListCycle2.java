package com.ocean.dsa.leetcode;

import com.ocean.factory.ListNodeFactory;
import com.ocean.model.ListNode;

public class Lec142LinkedListCycle2 {

    // ---------- LeetCode 142: Detect First Node of Cycle ----------
    public static ListNode detectCycle(ListNode head) {
        if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Detect if cycle exists
        while (fast != null && fast.next != null) {
            slow = slow.next;         // move 1 step
            fast = fast.next.next;    // move 2 steps

            if (slow == fast) {  // cycle detected
                break;
            }
        }

        // No cycle
        if (fast == null || fast.next == null) {
            return null;
        }

        // Step 2: Find cycle entry
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;  // cycle start node
    }

    public static void main(String[] args) {

        // ----------- TEST CASES -----------

        // Case 1: cycle starts at node with value = 2
        ListNode c1 = ListNodeFactory.buildList(new int[]{3, 2, 0, -4});
        ListNodeFactory.createCycle(c1, 1);      // cycle at index 1
        System.out.println("Test 1 (expected: 2): " + (detectCycle(c1) != null ? detectCycle(c1).val : "null"));

        // Case 2: single element, no cycle
        ListNode c2 = ListNodeFactory.buildList(new int[]{1});
        System.out.println("Test 2 (expected: null): " + detectCycle(c2));

        // Case 3: single element, cycle to itself
        ListNode c3 = ListNodeFactory.buildList(new int[]{1});
        ListNodeFactory.createCycle(c3, 0);
        System.out.println("Test 3 (expected: 1): " + detectCycle(c3).val);

        // Case 4: cycle in middle
        ListNode c4 = ListNodeFactory.buildList(new int[]{1, 2, 3, 4, 5});
        ListNodeFactory.createCycle(c4, 2);     // cycle at node 3
        System.out.println("Test 4 (expected: 3): " + detectCycle(c4).val);

        // Case 5: no cycle
        ListNode c5 = ListNodeFactory.buildList(new int[]{1, 2, 3});
        System.out.println("Test 5 (expected: null): " + detectCycle(c5));

        // Case 6: large list cycle near end
        ListNode c6 = ListNodeFactory.buildList(new int[]{10,20,30,40,50,60});
        ListNodeFactory.createCycle(c6, 4); // cycle at value 50
        System.out.println("Test 6 (expected: 50): " + detectCycle(c6).val);
    }

}