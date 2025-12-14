package com.ocean.dsa.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lec56MergeIntervals {

    // ---------- LeetCode 56: Merge Intervals ----------
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][0];
        }

        // Step 1: Sort by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];
        result.add(current);

        // Step 2: Merge overlapping intervals
        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];

            if (next[0] <= current[1]) {
                current[1] = Math.max(current[1], next[1]);
            } else {
                current = next;
                result.add(current);
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    private static void test(Lec56MergeIntervals obj, int[][] intervals) {
        int[][] result = obj.merge(intervals);
        System.out.println("Input:  " + Arrays.deepToString(intervals));
        System.out.println("Output: " + Arrays.deepToString(result));
        System.out.println("----------------------------------");
    }

    public static void main(String[] args) {
        Lec56MergeIntervals obj = new Lec56MergeIntervals();

        test(obj, new int[][]{{1,3},{2,6},{8,10},{15,18}});
        test(obj, new int[][]{{1,4},{4,5}});
        test(obj, new int[][]{{1,4},{0,4}});
        test(obj, new int[][]{{1,4}});
        test(obj, new int[][]{{1,10},{2,3},{4,8}});
        test(obj, new int[][]{{1,3},{5,7},{9,11}});
    }

}