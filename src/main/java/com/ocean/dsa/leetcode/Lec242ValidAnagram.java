package com.ocean.dsa.leetcode;

public class Lec242ValidAnagram {

    // ---------- LeetCode 242: Valid Anagram ----------
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            freq[c - 'a']--;
            if (freq[c - 'a'] < 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {

        Lec242ValidAnagram obj = new Lec242ValidAnagram();

        // ----------- TEST CASES -----------

        // Case 1: basic anagram
        System.out.println("Test 1 (expected: true): " + obj.isAnagram("anagram", "nagaram"));

        // Case 2: not an anagram
        System.out.println("Test 2 (expected: false): " + obj.isAnagram("rat", "car"));

        // Case 3: different lengths
        System.out.println("Test 3 (expected: false): " + obj.isAnagram("hello", "helloo"));

        // Case 4: empty strings
        System.out.println("Test 4 (expected: true): " + obj.isAnagram("", ""));

        // Case 5: one empty, one non-empty
        System.out.println("Test 5 (expected: false): " + obj.isAnagram("", "a"));

        // Case 6: string with repeating characters
        System.out.println("Test 6 (expected: true): " + obj.isAnagram("aabbcc", "baccab"));

        // Case 7: uppercase vs lowercase (case sensitive → false)
        System.out.println("Test 7 (expected: false): " + obj.isAnagram("Listen", "Silent"));
    }

}