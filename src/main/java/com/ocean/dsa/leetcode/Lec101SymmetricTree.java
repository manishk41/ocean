package com.ocean.dsa.leetcode;

import com.ocean.factory.TreeNodeFactory;
import com.ocean.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Lec101SymmetricTree {

    // ---------- LeetCode 101 Solution ----------
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        if (t1.val != t2.val) return false;

        // Compare opposite children
        return isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }

    public boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty()) {
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();

            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;

            // enqueue mirror children
            queue.add(t1.left);
            queue.add(t2.right);
            queue.add(t1.right);
            queue.add(t2.left);
        }
        return true;
    }

    public static void main(String[] args) {
        Lec101SymmetricTree obj = new Lec101SymmetricTree();

        // ----------- TEST CASES -----------

        // Case 1: symmetric tree
        TreeNode t1 = TreeNodeFactory.buildTree(new Integer[]{1, 2, 2, 3, 4, 4, 3});
        System.out.println("Test 1 (expected: true): " + obj.isSymmetric(t1));

        // Case 2: not symmetric
        TreeNode t2 = TreeNodeFactory.buildTree(new Integer[]{1, 2, 2, null, 3, null, 3});
        System.out.println("Test 2 (expected: false): " + obj.isSymmetric(t2));

        // Case 3: single node
        TreeNode t3 = TreeNodeFactory.buildTree(new Integer[]{1});
        System.out.println("Test 3 (expected: true): " + obj.isSymmetric(t3));

        // Case 4: null tree
        System.out.println("Test 4 (expected: true): " + obj.isSymmetric(null));

        // Case 5: asymmetric values
        TreeNode t5 = TreeNodeFactory.buildTree(new Integer[]{1, 2, 2, 3, 5, 4, 3});
        System.out.println("Test 5 (expected: false): " + obj.isSymmetric(t5));

        // Case 6: left subtree deeper than right subtree
        TreeNode t6 = TreeNodeFactory.buildTree(new Integer[]{1, 2, 2, 3, null, null, 3, 4});
        System.out.println("Test 6 (expected: false): " + obj.isSymmetric(t6));

        // Case 7: symmetric but with nulls
        TreeNode t7 = TreeNodeFactory.buildTree(new Integer[]{1, 2, 2, null, 3, 3, null});
        System.out.println("Test 7 (expected: true): " + obj.isSymmetric(t7));
    }

}