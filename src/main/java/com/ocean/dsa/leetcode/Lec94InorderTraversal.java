package com.ocean.dsa.leetcode;

import com.ocean.factory.TreeNodeFactory;
import com.ocean.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Lec94InorderTraversal {

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }

    private void inorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) return;

        // Step 1: Traverse left subtree
        inorderHelper(node.left, result);

        // Step 2: Visit node
        result.add(node.val);

        // Step 3: Traverse right subtree
        inorderHelper(node.right, result);
    }

    // ---------- LeetCode 94: Inorder Traversal ----------
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            // Reach leftmost node
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // Process node
            curr = stack.pop();
            result.add(curr.val);

            // Go right
            curr = curr.right;
        }

        return result;
    }

    public static void main(String[] args) {
        Lec94InorderTraversal obj = new Lec94InorderTraversal();

        // ----------- TEST CASES -----------

        // Case 1: General tree
        TreeNode t1 = TreeNodeFactory.buildTree(new Integer[]{1, 2, null, null, 3});
        System.out.println("Test 1 (expected: [2,3,1]): " + obj.inorderTraversal(t1));

        // Case 2: Single node
        TreeNode t2 = TreeNodeFactory.buildTree(new Integer[]{1});
        System.out.println("Test 2 (expected: [1]): " + obj.inorderTraversal(t2));

        // Case 3: Empty tree
        System.out.println("Test 3 (expected: []): " + obj.inorderTraversal(null));

        // Case 4: Balanced BST
        TreeNode t4 = TreeNodeFactory.buildTree(new Integer[]{4, 2, 6, 1, 3, 5, 7});
        System.out.println("Test 4 (expected: [1,2,3,4,5,6,7]): " + obj.inorderTraversal(t4));

        // Case 5: Skewed left
        TreeNode t5 = TreeNodeFactory.buildTree(new Integer[]{5, 4, null, 3, null, 2, null, 1});
        System.out.println("Test 5 (expected: [1,2,3,4,5]): " + obj.inorderTraversal(t5));

        // Case 6: Skewed right
        TreeNode t6 = TreeNodeFactory.buildTree(new Integer[]{1, null, 2, null, 3, null, 4, null, 5});
        System.out.println("Test 6 (expected: [1,2,3,4,5]): " + obj.inorderTraversal(t6));
    }
}
