package com.ocean.dsa.leetcode.dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    // ---------- LeetCode 300: Longest Increasing Subsequence ----------
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (nums.length == 0) return 0;
        int[] dp = new int[n];

        // 1. Every element itself is LIS of length 1
        Arrays.fill(dp, 1);

        // 2. Build DP: for each i, check all previous j < i
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }

        // 3. Answer is max in dp[]
        int ans = 0;
        for (int x : dp) {
            ans = Math.max(ans, x);
        }

        return ans;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence obj = new LongestIncreasingSubsequence();

        // ----------- TEST CASES -----------
        int[] t1 = {10,9,2,5,3,7,101,18};
        System.out.println("Test 1 (expected: 4): " + obj.lengthOfLIS(t1));

        int[] t2 = {0,1,0,3,2,3};
        System.out.println("Test 2 (expected: 4): " + obj.lengthOfLIS(t2));

        int[] t3 = {7,7,7,7,7,7};
        System.out.println("Test 3 (expected: 1): " + obj.lengthOfLIS(t3));

        int[] t4 = {1,3,6,7,9,4,10,5,6};
        System.out.println("Test 4 (expected: 6): " + obj.lengthOfLIS(t4));

        int[] t5 = {};
        System.out.println("Test 5 (expected: 0): " + obj.lengthOfLIS(t5));
    }

}