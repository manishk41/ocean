package com.ocean.dsa.leetcode.slidingwindow;

import java.util.Arrays;

public class LongestSubstringWithoutRepeatingCharacters {

    // ---------- LeetCode 3: Longest Substring Without Repeating Characters ----------
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        int[] lastSeen = new int[256]; // ASCII
        Arrays.fill(lastSeen, -1);

        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // If seen inside the window → move left
            if (lastSeen[c] >= left) {
                left = lastSeen[c] + 1;
            }

            // Update last seen index
            lastSeen[c] = right;

            // Update max length
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters obj = new LongestSubstringWithoutRepeatingCharacters();

        // ------------ TEST CASES ------------

        System.out.println("Test 1 (expected 3): " + obj.lengthOfLongestSubstring("abcabcbb"));
        System.out.println("Test 2 (expected 1): " + obj.lengthOfLongestSubstring("bbbbb"));
        System.out.println("Test 3 (expected 3): " + obj.lengthOfLongestSubstring("pwwkew"));
        System.out.println("Test 4 (expected 0): " + obj.lengthOfLongestSubstring(""));
        System.out.println("Test 5 (expected 5): " + obj.lengthOfLongestSubstring("abcde"));
        System.out.println("Test 6 (expected 2): " + obj.lengthOfLongestSubstring("abba"));  // tricky case
        System.out.println("Test 7 (expected 3): " + obj.lengthOfLongestSubstring("dvdf"));
    }

}