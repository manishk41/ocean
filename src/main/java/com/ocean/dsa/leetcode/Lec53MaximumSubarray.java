package com.ocean.dsa.leetcode;

public class Lec53MaximumSubarray {

    // ---------- LeetCode 53: Kadane's Algorithm ----------
    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        int start = 0, end = 0;
        int tempStart = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > currentSum + nums[i]) {
                currentSum = nums[i];
                tempStart = i;
            } else {
                currentSum += nums[i];
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }
        }

        System.out.println(start + " " + end);
        return maxSum;
    }

    public static void main(String[] args) {
        Lec53MaximumSubarray obj = new Lec53MaximumSubarray();

        // ----------- TEST CASES -----------
        System.out.println("Test 1 (expected: 6): " + obj.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println("Test 2 (expected: 1): " + obj.maxSubArray(new int[]{1}));
        System.out.println("Test 3 (expected: 23): " + obj.maxSubArray(new int[]{5,4,-1,7,8}));
        System.out.println("Test 4 (expected: -1): " + obj.maxSubArray(new int[]{-2,-3,-1,-5}));
        System.out.println("Test 5 (expected: 0): " + obj.maxSubArray(new int[]{0,0,0}));
        System.out.println("Test 6 (expected: 10): " + obj.maxSubArray(new int[]{10}));
        System.out.println("Test 7 (expected: 3): " + obj.maxSubArray(new int[]{1,2,-10,3}));
    }

}