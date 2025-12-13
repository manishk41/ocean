package com.ocean.dsa.leetcode;

import java.util.*;

public class Lec49GroupAnagrams {

    // ---------- LeetCode 49: Group Anagrams ----------
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        Lec49GroupAnagrams obj = new Lec49GroupAnagrams();

        // ----------- TEST CASES -----------

        // Case 1: basic
        System.out.println("Test 1:");
        print(obj.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));

        // Case 2: all anagrams
        System.out.println("Test 2:");
        print(obj.groupAnagrams(new String[]{"abc", "bca", "cab"}));

        // Case 3: no anagrams
        System.out.println("Test 3:");
        print(obj.groupAnagrams(new String[]{"a", "b", "c"}));

        // Case 4: duplicates
        System.out.println("Test 4:");
        print(obj.groupAnagrams(new String[]{"aa", "aa", "aa"}));

        // Case 5: empty input
        System.out.println("Test 5:");
        print(obj.groupAnagrams(new String[]{}));

        // Case 6: includes empty string
        System.out.println("Test 6:");
        print(obj.groupAnagrams(new String[]{"", ""}));

        // Case 7: mixed upper/lowercase (case sensitive)
        System.out.println("Test 7:");
        print(obj.groupAnagrams(new String[]{"Eat", "Tea", "ate"}));
    }

    // ---------- Pretty Print Utility ----------
    public static void print(List<List<String>> groups) {
        for (List<String> group : groups) {
            System.out.println(group);
        }
        System.out.println();
    }

}