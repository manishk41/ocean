package com.ocean.leetcode.tree;

import com.ocean.leetcode.factory.TreeNodeFactory;
import com.ocean.leetcode.model.TreeNode;

import java.util.Stack;

// similar to InorderTraversal

public class BSTIterator {

    private Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        pushLeft(root);
    }

    private void pushLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public int next() {
        TreeNode curr = stack.pop();
        if (curr.right != null) pushLeft(curr.right);
        return curr.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public static void main(String[] args) {

        // ----------- TEST CASES -----------

        // Case 1: Simple BST
        TreeNode root1 = TreeNodeFactory.buildTree(new Integer[]{7, 3, 15, null, null, 9, 20});
        BSTIterator it1 = new BSTIterator(root1);

        System.out.print("Test 1 (expected: 3 7 9 15 20): ");
        while (it1.hasNext()) {
            System.out.print(it1.next() + " ");
        }
        System.out.println();

        // Case 2: Single node
        TreeNode root2 = TreeNodeFactory.buildTree(new Integer[]{10});
        BSTIterator it2 = new BSTIterator(root2);
        System.out.print("Test 2 (expected: 10): ");
        while (it2.hasNext()) System.out.print(it2.next() + " ");
        System.out.println();

        // Case 3: Empty tree
        BSTIterator it3 = new BSTIterator(null);
        System.out.print("Test 3 (expected: nothing): ");
        while (it3.hasNext()) System.out.print(it3.next() + " ");
        System.out.println();

        // Case 4: Larger BST
        TreeNode root4 = TreeNodeFactory.buildTree(new Integer[]{8, 3, 10, 1, 6, null, 14, null, null, 4, 7, 13});
        BSTIterator it4 = new BSTIterator(root4);

        System.out.print("Test 4 (expected: 1 3 4 6 7 8 10 13 14): ");
        while (it4.hasNext()) System.out.print(it4.next() + " ");
        System.out.println();

        // Case 5: Skewed left (like linked list)
        TreeNode root5 = TreeNodeFactory.buildTree(new Integer[]{5, 4, null, 3, null, 2, null, 1});
        BSTIterator it5 = new BSTIterator(root5);

        System.out.print("Test 5 (expected: 1 2 3 4 5): ");
        while (it5.hasNext()) System.out.print(it5.next() + " ");
        System.out.println();

        // Case 6: Skewed right
        TreeNode root6 = TreeNodeFactory.buildTree(new Integer[]{1, null, 2, null, 3, null, 4});
        BSTIterator it6 = new BSTIterator(root6);

        System.out.print("Test 6 (expected: 1 2 3 4): ");
        while (it6.hasNext()) System.out.print(it6.next() + " ");
        System.out.println();
    }
}