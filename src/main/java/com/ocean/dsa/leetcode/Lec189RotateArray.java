package com.ocean.dsa.leetcode;

import java.util.Arrays;

public class Lec189RotateArray {

    // ---------- LeetCode 189: Rotate Array ----------
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return;

        k = k % n; // handle k > n
        if (k == 0) return;

        reverse(nums, 0, n - 1);    // [7,6,5,4,3,2,1]
        reverse(nums, 0, k - 1);    // [5,6,7,4,3,2,1]
        reverse(nums, k, n - 1);        // [5,6,7,1,2,3,4]
    }

    // ---------- Helper: Reverse array portion ----------
    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    private static void test(Lec189RotateArray obj, int[] nums, int k) {
        System.out.println("Original: " + Arrays.toString(nums));
        obj.rotate(nums, k);
        System.out.println("k = " + k);
        System.out.println("Rotated:  " + Arrays.toString(nums));
        System.out.println("----------------------------------");
    }

    public static void main(String[] args) {
        Lec189RotateArray obj = new Lec189RotateArray();

        test(obj, new int[]{1,2,3,4,5,6,7}, 3);
        test(obj, new int[]{-1,-100,3,99}, 2);
        test(obj, new int[]{1,2}, 3);
        test(obj, new int[]{1}, 10);
        test(obj, new int[]{1,2,3,4,5}, 0);
    }

}