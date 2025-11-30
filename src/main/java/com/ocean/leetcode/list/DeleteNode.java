package com.ocean.leetcode.list;

import com.ocean.leetcode.factory.ListNodeFactory;
import com.ocean.leetcode.model.ListNode;

public class DeleteNode {

    // ------------ LeetCode 237: Delete node WITHOUT head --------------
    public static void deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            throw new IllegalArgumentException("Cannot delete tail or null node");
        }

        node.val = node.next.val;      // Copy next value
        node.next = node.next.next;    // Skip next node
    }

    public static void main(String[] args) {

        // Case 1: delete middle node
        ListNode head1 = ListNodeFactory.buildList(new int[]{4, 5, 1, 9});
        ListNode node1 = head1.next; // node with value = 5
        deleteNode(node1);
        System.out.print("Test 1 (expected: 4 -> 1 -> 9): ");
        ListNodeFactory.printList(head1);

        // Case 2: delete node 1 in list: 1 -> 2 -> 3
        ListNode head2 = ListNodeFactory.buildList(new int[]{1, 2, 3});
        ListNode node2 = head2; // node 1
        deleteNode(node2);
        System.out.print("Test 2 (expected: 2 -> 3): ");
        ListNodeFactory.printList(head2);

        // Case 3: delete second element
        ListNode head3 = ListNodeFactory.buildList(new int[]{10, 20, 30, 40});
        ListNode node3 = head3.next; // 20
        deleteNode(node3);
        System.out.print("Test 3 (expected: 10 -> 30 -> 40): ");
        ListNodeFactory.printList(head3);

        // Case 4: deleting last node (INVALID SCENARIO)
        // LeetCode GUARANTEES node is NOT tail.
        // But we test scenario manually.

        ListNode head4 = ListNodeFactory.buildList(new int[]{7, 8, 9});
        ListNode tail = head4.next.next; // tail node
        System.out.print("Test 4 (invalid case, cannot delete tail, expect unchanged): ");
        try {
            deleteNode(tail);
        } catch (Exception e) {
            System.out.print("(error caught) ");
        }
        ListNodeFactory.printList(head4);
    }

}