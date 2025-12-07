package com.ocean.dsa.leetcode.tree;

import com.ocean.dsa.leetcode.factory.TreeNodeFactory;
import com.ocean.dsa.leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();  // dequeue node
                level.add(node.val);

                // enqueue children
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(level); // add current level to result
        }
        return result;
    }

    public static void main(String[] args) {
        LevelOrderTraversal obj = new LevelOrderTraversal();

        // ----------- TEST CASES -----------

        TreeNode t0 = TreeNodeFactory.buildTree(new Integer[]{1, null, 2, null, null, 3});
        System.out.println("Test 1 (expected: [[1],[2],[3]]): " + obj.levelOrder(t0));

        // Case 1: normal balanced tree
//        TreeNode t1 = TreeNodeFactory.buildTree(new Integer[]{3, 9, 20, null, null, 15, 7});
//        System.out.println("Test 1 (expected: [[3],[9,20],[15,7]]): " + obj.levelOrder(t1));
//
//        // Case 2: single node
//        TreeNode t2 = TreeNodeFactory.buildTree(new Integer[]{1});
//        System.out.println("Test 2 (expected: [[1]]): " + obj.levelOrder(t2));
//
//        // Case 3: empty tree
//        System.out.println("Test 3 (expected: []): " + obj.levelOrder(null));
//
//        // Case 4: skewed left tree
//        TreeNode t4 = TreeNodeFactory.buildTree(new Integer[]{1, 2, null, 3, null, 4});
//        System.out.println("Test 4 (expected: [[1],[2],[3],[4]]): " + obj.levelOrder(t4));
//
//        // Case 5: skewed right tree
//        TreeNode t5 = TreeNodeFactory.buildTree(new Integer[]{1, null, 2, null, 3, null, 4});
//        System.out.println("Test 5 (expected: [[1],[2],[3],[4]]): " + obj.levelOrder(t5));
//
//        // Case 6: complete binary tree
//        TreeNode t6 = TreeNodeFactory.buildTree(new Integer[]{1, 2, 3, 4, 5, 6, 7});
//        System.out.println("Test 6 (expected: [[1],[2,3],[4,5,6,7]]): " + obj.levelOrder(t6));
//
//        // Case 7: tree with nulls in between
//        TreeNode t7 = TreeNodeFactory.buildTree(new Integer[]{1, 2, 3, null, 5, 6, null});
//        System.out.println("Test 7 (expected: [[1],[2,3],[5,6]]): " + obj.levelOrder(t7));
    }



}