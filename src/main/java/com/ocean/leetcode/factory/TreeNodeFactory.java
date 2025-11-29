package com.ocean.leetcode.factory;

import com.ocean.leetcode.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNodeFactory {

    public static TreeNode buildTree(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            TreeNode curr = queue.poll();

            if (i < arr.length && arr[i] != null) {
                curr.left = new TreeNode(arr[i]);
                queue.offer(curr.left);
            }
            i++;

            if (i < arr.length && arr[i] != null) {
                curr.right = new TreeNode(arr[i]);
                queue.offer(curr.right);
            }
            i++;
        }
        return root;
    }

    // ---------- Print Tree (Sideways) ----------
    public static void printTree(TreeNode root) {
        printTreeHelper(root, 0);
    }

    private static void printTreeHelper(TreeNode node, int level) {
        if (node == null) return;

        // print right subtree first
        printTreeHelper(node.right, level + 1);

        // indent based on level
        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }
        System.out.println(node.val);

        // print left subtree
        printTreeHelper(node.left, level + 1);
    }
}