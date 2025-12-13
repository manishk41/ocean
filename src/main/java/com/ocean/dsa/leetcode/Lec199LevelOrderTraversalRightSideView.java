package com.ocean.dsa.leetcode;

import com.ocean.factory.TreeNodeFactory;
import com.ocean.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Lec199LevelOrderTraversalRightSideView {

    // ---------- LeetCode 199: Right Side View ----------
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            TreeNode rightmost = null;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                rightmost = node;

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            result.add(rightmost.val);
        }

        return result;
    }

    public static void main(String[] args) {
        Lec199LevelOrderTraversalRightSideView obj = new Lec199LevelOrderTraversalRightSideView();

        // ----------- TEST CASES -----------

        // Case 1: Standard tree
        TreeNode t1 = TreeNodeFactory.buildTree(new Integer[]{1, 2, 3, null, 5, null, 4});
        System.out.println("Test 1 (expected: [1,3,4]): " + obj.rightSideView(t1));

        // Case 2: Only left children
        TreeNode t2 = TreeNodeFactory.buildTree(new Integer[]{1, 2, null, 3, null, 4});
        System.out.println("Test 2 (expected: [1,2,3,4]): " + obj.rightSideView(t2));

        // Case 3: Only right children
        TreeNode t3 = TreeNodeFactory.buildTree(new Integer[]{1, null, 2, null, 3, null, 4});
        System.out.println("Test 3 (expected: [1,2,3,4]): " + obj.rightSideView(t3));

        // Case 4: Empty tree
        System.out.println("Test 4 (expected: []): " + obj.rightSideView(null));

        // Case 5: Full tree
        TreeNode t5 = TreeNodeFactory.buildTree(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        System.out.println("Test 5 (expected: [1,3,7]): " + obj.rightSideView(t5));

        // Case 6: Random gaps
        TreeNode t6 = TreeNodeFactory.buildTree(new Integer[]{1, 2, 3, null, 5, null, 4, null, null, 7});
        System.out.println("Test 6 (expected: [1,3,4,7]): " + obj.rightSideView(t6));
    }

}