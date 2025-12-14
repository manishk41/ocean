package com.ocean.dsa.leetcode;

import java.util.Arrays;

public class Lec238ProductOfArrayExceptSelf {

    // ---------- LeetCode 238: Product of Array Except Self ----------
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] result = new int[n];

        // Prefix array
        prefix[0] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        // Suffix array
        suffix[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        // Result
        for (int i = 0; i < n; i++) {
            result[i] = prefix[i] * suffix[i];
        }

        return result;
    }

    private static void test(Lec238ProductOfArrayExceptSelf obj, int[] nums) {
        int[] result = obj.productExceptSelf(nums);
        System.out.println("Input:  " + Arrays.toString(nums));
        System.out.println("Output: " + Arrays.toString(result));
        System.out.println("--------------------------------");
    }

    public static void main(String[] args) {
        Lec238ProductOfArrayExceptSelf obj = new Lec238ProductOfArrayExceptSelf();

        test(obj, new int[]{1, 2, 3, 4});
        test(obj, new int[]{-1, 1, 0, -3, 3});
        test(obj, new int[]{0, 0});
        test(obj, new int[]{5});
        test(obj, new int[]{2, 3});
    }
}