package com.ocean.dsa.leetcode.tree;

import com.ocean.dsa.leetcode.factory.TreeNodeFactory;
import com.ocean.dsa.leetcode.model.TreeNode;

public class ValidateBST {

    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long min, long max) {
        if (node == null) return true;

        // current node value must be between min and max
        if (node.val <= min || node.val >= max)
            return false;

        // check left and right subtrees recursively
        return validate(node.left, min, node.val) &&
                validate(node.right, node.val, max);
    }

    public static void main(String[] args) {
        ValidateBST obj = new ValidateBST();

        // ----------- TEST CASES -----------

        // Case 1: Valid BST
        TreeNode t1 = TreeNodeFactory.buildTree(new Integer[]{2, 1, 3});
        System.out.println("Test 1 (expected: true): " + obj.isValidBST(t1));

        // Case 2: Not a BST because 3 is in left subtree of 4
        TreeNode t2 = TreeNodeFactory.buildTree(new Integer[]{5, 1, 4, null, null, 3, 6});
        System.out.println("Test 2 (expected: false): " + obj.isValidBST(t2));

        // Case 3: Single node
        TreeNode t3 = TreeNodeFactory.buildTree(new Integer[]{1});
        System.out.println("Test 3 (expected: true): " + obj.isValidBST(t3));

        // Case 4: Empty tree
        System.out.println("Test 4 (expected: true): " + obj.isValidBST(null));

        // Case 5: Invalid BST: duplicates on left or right
        TreeNode t5 = TreeNodeFactory.buildTree(new Integer[]{2, 2, 2});
        System.out.println("Test 5 (expected: false): " + obj.isValidBST(t5));

        // Case 6: Valid large BST
        TreeNode t6 = TreeNodeFactory.buildTree(new Integer[]{10, 5, 15, 2, 7, 12, 20});
        System.out.println("Test 6 (expected: true): " + obj.isValidBST(t6));

        // Case 7: Invalid deeper subtree
        TreeNode t7 = TreeNodeFactory.buildTree(new Integer[]{10, 5, 15, 2, 7, 6, 20});
        System.out.println("Test 7 (expected: false): " + obj.isValidBST(t7));

        // Case 8: Valid extreme values BST
        TreeNode t8 = TreeNodeFactory.buildTree(new Integer[]{Integer.MIN_VALUE, null, Integer.MAX_VALUE});
        System.out.println("Test 8 (expected: true): " + obj.isValidBST(t8));
    }

}