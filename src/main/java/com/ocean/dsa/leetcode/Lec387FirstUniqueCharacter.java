package com.ocean.dsa.leetcode;

public class Lec387FirstUniqueCharacter {

    // ---------- LeetCode 387: First Unique Character ----------
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;

        int[] freq = new int[26];

        // count frequencies
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // find first index with freq = 1
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Lec387FirstUniqueCharacter obj = new Lec387FirstUniqueCharacter();

        // ----------- TEST CASES -----------

        // Case 1: normal string
        System.out.println("Test 1 (expected: 0): " + obj.firstUniqChar("leetcode"));

        // Case 2: unique in middle
        System.out.println("Test 2 (expected: 2): " + obj.firstUniqChar("loveleetcode"));

        // Case 3: no unique characters
        System.out.println("Test 3 (expected: -1): " + obj.firstUniqChar("aabbcc"));

        // Case 4: single character
        System.out.println("Test 4 (expected: 0): " + obj.firstUniqChar("z"));

        // Case 5: empty string
        System.out.println("Test 5 (expected: -1): " + obj.firstUniqChar(""));

        // Case 6: mixed repeating
        System.out.println("Test 6 (expected: 4): " + obj.firstUniqChar("aabbcdde"));

        // Case 7: long string with unique near end
        System.out.println("Test 7 (expected: 8): " + obj.firstUniqChar("aaaabbbbz"));
    }

}