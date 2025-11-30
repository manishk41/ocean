package com.ocean.leetcode.array;

import java.util.Arrays;

public class MoveZeroes {

    // ---------- LeetCode 283: Move Zeroes ----------
    public void moveZeroes(int[] nums) {
        int insertPos = 0;

        // Move all non-zero values forward
        for (int num : nums) {
            if (num != 0) {
                nums[insertPos++] = num;
            }
        }

        // Fill rest of array with zeros
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }

    public static void main(String[] args) {

        MoveZeroes obj = new MoveZeroes();

        // ----------- TEST CASES -----------

        // Case 1: mixed values
        int[] a1 = {0, 1, 0, 3, 12};
        obj.moveZeroes(a1);
        System.out.println("Test 1 (expected: [1,3,12,0,0]): " + Arrays.toString(a1));

        // Case 2: no zeros
        int[] a2 = {1, 2, 3};
        obj.moveZeroes(a2);
        System.out.println("Test 2 (expected: [1,2,3]): " + Arrays.toString(a2));

        // Case 3: all zeros
        int[] a3 = {0, 0, 0};
        obj.moveZeroes(a3);
        System.out.println("Test 3 (expected: [0,0,0]): " + Arrays.toString(a3));

        // Case 4: zeros already at end
        int[] a4 = {1, 2, 3, 0, 0};
        obj.moveZeroes(a4);
        System.out.println("Test 4 (expected: [1,2,3,0,0]): " + Arrays.toString(a4));

        // Case 5: single element zero
        int[] a5 = {0};
        obj.moveZeroes(a5);
        System.out.println("Test 5 (expected: [0]): " + Arrays.toString(a5));

        // Case 6: single element non-zero
        int[] a6 = {7};
        obj.moveZeroes(a6);
        System.out.println("Test 6 (expected: [7]): " + Arrays.toString(a6));

        // Case 7: random distribution
        int[] a7 = {4, 0, 5, 0, 0, 6, 7};
        obj.moveZeroes(a7);
        System.out.println("Test 7 (expected: [4,5,6,7,0,0,0]): " + Arrays.toString(a7));
    }

}