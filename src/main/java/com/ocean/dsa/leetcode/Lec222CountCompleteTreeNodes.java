package com.ocean.dsa.leetcode;

import com.ocean.factory.TreeNodeFactory;
import com.ocean.model.TreeNode;

public class Lec222CountCompleteTreeNodes {

    public int countNodes2(TreeNode root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // ---------- LeetCode 222: Count Complete Tree Nodes ----------
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);

        if (leftHeight == rightHeight) {
            // perfect tree
            return (1 << leftHeight) - 1;
        }

        // recursive count
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int getLeftHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }

    private int getRightHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.right;
        }
        return height;
    }

    public static void main(String[] args) {
        Lec222CountCompleteTreeNodes obj = new Lec222CountCompleteTreeNodes();

        // ----------- TEST CASES -----------

        // Case 1: simple complete tree
        TreeNode t1 = TreeNodeFactory.buildTree(new Integer[]{1, 2, 3, 4, 5, 6});
        System.out.println("Test 1 (expected: 6): " + obj.countNodes(t1));

        // Case 2: perfect tree (2^3 - 1 = 7)
        TreeNode t2 = TreeNodeFactory.buildTree(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        System.out.println("Test 2 (expected: 7): " + obj.countNodes(t2));

        // Case 3: empty tree
        System.out.println("Test 3 (expected: 0): " + obj.countNodes(null));

        // Case 4: single node
        TreeNode t4 = TreeNodeFactory.buildTree(new Integer[]{1});
        System.out.println("Test 4 (expected: 1): " + obj.countNodes(t4));

        // Case 5: complete but not perfect
        TreeNode t5 = TreeNodeFactory.buildTree(new Integer[]{1, 2, 3, 4, 5, null, null});
        System.out.println("Test 5 (expected: 5): " + obj.countNodes(t5));

        // Case 6: skewed left near bottom level
        TreeNode t6 = TreeNodeFactory.buildTree(new Integer[]{1, 2, 3, 4, null, null, null});
        System.out.println("Test 6 (expected: 4): " + obj.countNodes(t6));

        // Case 7: deeper incomplete level
        TreeNode t7 = TreeNodeFactory.buildTree(new Integer[]{1, 2, 3, 4, 5, 6, null, 8});
        System.out.println("Test 7 (expected: 7): " + obj.countNodes(t7));
    }
}
