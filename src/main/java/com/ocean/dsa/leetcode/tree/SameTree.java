package com.ocean.dsa.leetcode.tree;

import com.ocean.dsa.leetcode.factory.TreeNodeFactory;
import com.ocean.dsa.leetcode.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Case 1: both null → same
        if (p == null && q == null) return true;

        // Case 2: only one null → not same
        if (p == null || q == null) return false;

        // Case 3: value mismatch
        if (p.val != q.val) return false;

        // Case 4: check left & right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSameTree2(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);

        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();

            if (node1 == null && node2 == null) continue;
            if (node1 == null || node2 == null) return false;
            if (node1.val != node2.val) return false;

            queue.offer(node1.left);
            queue.offer(node2.left);
            queue.offer(node1.right);
            queue.offer(node2.right);
        }
        return true;
    }

    public static void main(String[] args) {
        SameTree obj = new SameTree();

        // ----------- TEST CASES -----------

        // Case 1: identical trees
        TreeNode p1 = TreeNodeFactory.buildTree(new Integer[]{1, 2, 3});
        TreeNode q1 = TreeNodeFactory.buildTree(new Integer[]{1, 2, 3});
        System.out.println("Test 1 (expected: true): " + obj.isSameTree(p1, q1));

        // Case 2: different structure
        TreeNode p2 = TreeNodeFactory.buildTree(new Integer[]{1, 2});
        TreeNode q2 = TreeNodeFactory.buildTree(new Integer[]{1, null, 2});
        System.out.println("Test 2 (expected: false): " + obj.isSameTree(p2, q2));

        // Case 3: different values
        TreeNode p3 = TreeNodeFactory.buildTree(new Integer[]{1, 2, 1});
        TreeNode q3 = TreeNodeFactory.buildTree(new Integer[]{1, 1, 2});
        System.out.println("Test 3 (expected: false): " + obj.isSameTree(p3, q3));

        // Case 4: both null
        System.out.println("Test 4 (expected: true): " + obj.isSameTree(null, null));

        // Case 5: one null, one non-null
        TreeNode p5 = TreeNodeFactory.buildTree(new Integer[]{1});
        System.out.println("Test 5 (expected: false): " + obj.isSameTree(p5, null));

        // Case 6: larger identical trees
        TreeNode p6 = TreeNodeFactory.buildTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        TreeNode q6 = TreeNodeFactory.buildTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        System.out.println("Test 6 (expected: true): " + obj.isSameTree(p6, q6));

        // Case 7: larger non-identical trees
        TreeNode p7 = TreeNodeFactory.buildTree(new Integer[]{3, 9, 20, null, 5, 15, 7});
        TreeNode q7 = TreeNodeFactory.buildTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        System.out.println("Test 7 (expected: false): " + obj.isSameTree(p7, q7));
    }

}