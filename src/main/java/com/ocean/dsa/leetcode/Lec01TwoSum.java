package com.ocean.dsa.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Lec01TwoSum {

    // ---------- LeetCode 1: Two Sum ----------
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); // value -> index

        for (int i = 0; i < nums.length; i++) {
            int needed = target - nums[i];

            if (map.containsKey(needed)) {
                return new int[]{map.get(needed), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{-1, -1}; // if not found (non-LeetCode behavior but good for local testing)
    }

    public static void main(String[] args) {
        Lec01TwoSum obj = new Lec01TwoSum();

        // ----------- TEST CASES -----------
        System.out.println("Test 1 (expected: [0,1]): " + Arrays.toString(obj.twoSum(new int[]{2,7,11,15}, 9)));
        System.out.println("Test 2 (expected: [1,2]): " + Arrays.toString(obj.twoSum(new int[]{3,2,4}, 6)));
        System.out.println("Test 3 (expected: [0,1]): " + Arrays.toString(obj.twoSum(new int[]{3,3}, 6)));
        System.out.println("Test 4 (expected: [2,4]): " + Arrays.toString(obj.twoSum(new int[]{1,5,10,7,12}, 22)));
        System.out.println("Test 5 (expected: [-1,-1]): " + Arrays.toString(obj.twoSum(new int[]{1,2,3}, 100)));
    }

}