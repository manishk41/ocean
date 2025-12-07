package com.ocean.dsa.leetcode.tree;

import com.ocean.dsa.leetcode.factory.TreeNodeFactory;
import com.ocean.dsa.leetcode.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepth {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;  // Base case
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1 + Math.max(leftDepth, rightDepth);
    }

    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // nodes in current level

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            depth++; // after one full level
        }

        return depth;
    }

    public static void main(String[] args) {
        MaximumDepth obj = new MaximumDepth();

        // ----------- TEST CASES -----------

        // Case 1: Balanced binary tree
        TreeNode t1 = TreeNodeFactory.buildTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        System.out.println("Test 1 (expected: 3): " + obj.maxDepth(t1));

        // Case 2: Single node
        TreeNode t2 = TreeNodeFactory.buildTree(new Integer[]{1});
        System.out.println("Test 2 (expected: 1): " + obj.maxDepth(t2));

        // Case 3: Empty tree
        System.out.println("Test 3 (expected: 0): " + obj.maxDepth(null));

        // Case 4: Skewed left tree (like a linked list)
        TreeNode t4 = TreeNodeFactory.buildTree(new Integer[]{1, 2, null, 3, null, 4});
        System.out.println("Test 4 (expected: 4): " + obj.maxDepth(t4));

        // Case 5: Skewed right tree
        TreeNode t5 = TreeNodeFactory.buildTree(new Integer[]{1, null, 2, null, 3, null, 4});
        System.out.println("Test 5 (expected: 4): " + obj.maxDepth(t5));

        // Case 6: Complete binary tree
        TreeNode t6 = TreeNodeFactory.buildTree(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        System.out.println("Test 6 (expected: 3): " + obj.maxDepth(t6));

        // Case 7: Uneven tree with deeper left subtree
        TreeNode t7 = TreeNodeFactory.buildTree(new Integer[]{1, 2, 3, 4, null, null, null, 5});
        System.out.println("Test 7 (expected: 4): " + obj.maxDepth(t7));
    }
}