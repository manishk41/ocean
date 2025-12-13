package com.ocean.dsa.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Lec54SpiralMatrix {

    // ---------- LeetCode 54: Spiral Matrix ----------
    public List<Integer> spiralOrder(int[][] A) {
        List<Integer> result = new ArrayList<>();

        if (A == null || A.length == 0) return result;
        int m = A.length;
        int n = A[0].length;

        int T = 0, B = m-1, L = 0, R = n-1;
        int dir = 0;
        while(T <= B && L <= R) {
            if(dir == 0) {
                for(int i = L; i <= R; i++)
                    result.add(A[T][i]);
                T++;
            } else if(dir == 1) {
                for(int i = T; i <= B; i++)
                    result.add(A[i][R]);
                R--;
            } else if(dir == 2) {
                for(int i = R; i >= L; i--)
                    result.add(A[B][i]);
                B--;
            } else if(dir == 3) {
                for(int i = B; i >= T; i--)
                    result.add(A[i][L]);
                L++;
            }
            dir = (dir+1)%4;
        }

        return result;
    }

    public static void main(String[] args) {
        Lec54SpiralMatrix obj = new Lec54SpiralMatrix();

        // ----------- TEST CASES -----------

        int[][] m1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println("Test 1 (expected: 1 2 3 6 9 8 7 4 5) :");
        System.out.println(obj.spiralOrder(m1));

        int[][] m2 = {
                {1, 2},
                {3, 4}
        };
        System.out.println("Test 2 (expected: [1,2,4,3]):");
        System.out.println(obj.spiralOrder(m2));

        int[][] m3 = {
                {1}
        };
        System.out.println("Test 3 (expected: [1]):");
        System.out.println(obj.spiralOrder(m3));

        int[][] m4 = {
                {1, 2, 3, 4}
        };
        System.out.println("Test 4 (expected: [1,2,3,4]):");
        System.out.println(obj.spiralOrder(m4));

        int[][] m5 = {
                {1},
                {2},
                {3},
                {4}
        };
        System.out.println("Test 5 (expected: [1,2,3,4]):");
        System.out.println(obj.spiralOrder(m5));

        int[][] m6 = {
                {2, 5, 8},
                {4, 0, -1}
        };
        System.out.println("Test 6 (expected: [2,5,8,-1,0,4]):");
        System.out.println(obj.spiralOrder(m6));
    }

}