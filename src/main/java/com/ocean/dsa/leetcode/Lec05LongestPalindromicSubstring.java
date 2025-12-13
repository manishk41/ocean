package com.ocean.dsa.leetcode;

public class Lec05LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i);                                     // odd expansion
            System.out.println(s + " " + i + " " + i + " len1: " + len1);

            int len2 = expand(s, i, i + 1);                             // even expansion
            System.out.println(s + " " + i + " " + (i+1) + " len2: " + len2);
            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        Lec05LongestPalindromicSubstring obj = new Lec05LongestPalindromicSubstring();

        // ----------- TEST CASES -----------
        System.out.println("Test 1 (expected: bab/aba): " + obj.longestPalindrome("babad"));
        System.out.println("Test 2 (expected: bb): " + obj.longestPalindrome("cbbd"));
        System.out.println("Test 3 (expected: a): " + obj.longestPalindrome("a"));
        System.out.println("Test 4 (expected: a): " + obj.longestPalindrome("ac"));
        System.out.println("Test 5 (expected: racecar): " + obj.longestPalindrome("racecar"));
        System.out.println("Test 6 (expected: abccba): " + obj.longestPalindrome("abccba"));
        System.out.println("Test 7 (expected: aaa): " + obj.longestPalindrome("aaa"));
        System.out.println("Test 8 (expected: empty): " + obj.longestPalindrome(""));
    }

}