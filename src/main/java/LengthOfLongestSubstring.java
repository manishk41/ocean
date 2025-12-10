import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {

    /*
    * Move right pointer one step at a time:
    * a. If the character is not in the set, add it and update max length.
    * b. If the character is already in the set,
    *       remove characters from the left until the duplicate is removed.
    * */
    // ---------- LeetCode 3: Longest Substring Without Repeating Characters ----------
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(c);
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }


    public static void main(String[] args) {
        LengthOfLongestSubstring obj = new LengthOfLongestSubstring();

        System.out.println("Test 1 (expected: 3): " + obj.lengthOfLongestSubstring("abcabcbb"));
        System.out.println("Test 2 (expected: 1): " + obj.lengthOfLongestSubstring("bbbbb"));
        System.out.println("Test 3 (expected: 3): " + obj.lengthOfLongestSubstring("pwwkew"));
        System.out.println("Test 4 (expected: 0): " + obj.lengthOfLongestSubstring(""));
        System.out.println("Test 5 (expected: 1): " + obj.lengthOfLongestSubstring(" "));
        System.out.println("Test 6 (expected: 2): " + obj.lengthOfLongestSubstring("au"));
        System.out.println("Test 7 (expected: 3): " + obj.lengthOfLongestSubstring("dvdf"));
        System.out.println("Test 8 (expected: 5): " + obj.lengthOfLongestSubstring("abcde"));
        System.out.println("Test 9 (expected: 2): " + obj.lengthOfLongestSubstring("abba"));
    }

}