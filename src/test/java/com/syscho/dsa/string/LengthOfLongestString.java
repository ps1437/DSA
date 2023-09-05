package com.syscho.dsa.string;

//How do you find the length of the longest substring without repeating characters?
//Given string str, How do you find the longest palindromic substring in str?

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthOfLongestString {

    public int lengthOfLongestSubstringer(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (map.containsKey(c)) {
                if (start <= map.get(c)) {
                    start = map.get(c) + 1;
                }
            }

            count = Math.max(count, i - start + 1);
            map.put(c, i);
        }
        return count;
    }

    public int lengthOfLongestSubstring(String s) {

        Set<Character> set = new HashSet();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            while (!set.add(s.charAt(i))) {
                set.remove(s.charAt(left++));
            }
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        int length = s.length(), longest = 0;
        int[] nextIndex = new int[128];

        for (int i = 0, l = 0; i < length; i++) {
            l = Math.max(nextIndex[s.charAt(i)], l);
            longest = Math.max(longest, i - l + 1);
            nextIndex[s.charAt(i)] = i + 1;
        }

        return longest;
    }


    public int lengthOfLongestSubstringSlidingWindow(String s) {
        int[] chars = new int[128];

        int left = 0;
        int right = 0;

        int res = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            chars[r]++;

            while (chars[r] > 1) {
                char l = s.charAt(left);
                chars[l]--;
                left++;
            }

            res = Math.max(res, right - left + 1);

            right++;
        }
        return res;
    }


    @Test
    void testLengthOfLongestSubstring() {
        Assertions.assertEquals(3, lengthOfLongestSubstring("abcabcbb"));
        Assertions.assertEquals(1, lengthOfLongestSubstring("bbbbb"));
        Assertions.assertEquals(3, lengthOfLongestSubstring("pwwkew"));

        Assertions.assertEquals(3, lengthOfLongestSubstring2("abcabcbb"));
        Assertions.assertEquals(1, lengthOfLongestSubstring2("bbbbb"));
        Assertions.assertEquals(3, lengthOfLongestSubstring2("pwwkew"));

        Assertions.assertEquals(3, lengthOfLongestSubstringSlidingWindow("abcabcbb"));
        Assertions.assertEquals(1, lengthOfLongestSubstringSlidingWindow("bbbbb"));
        Assertions.assertEquals(3, lengthOfLongestSubstringSlidingWindow("pwwkew"));


        Assertions.assertEquals(3, lengthOfLongestSubstringer("abcabcbb"));
        Assertions.assertEquals(1, lengthOfLongestSubstringer("bbbbb"));
        Assertions.assertEquals(3, lengthOfLongestSubstringer("pwwkew"));
    }


    public int lengthOfLongestSubstringBrute(String s) {

        int n = s.length();

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (checkRepetition(s, i, j)) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }

        return res;
    }

    private boolean checkRepetition(String s, int start, int end) {
        int[] chars = new int[128];

        for (int i = start; i <= end; i++) {
            char c = s.charAt(i);
            chars[c]++;
            if (chars[c] > 1) {
                return false;
            }
        }
        return true;
    }

    @Test
    void testLengthOfLongestSubstringBrute() {
        Assertions.assertEquals(3, lengthOfLongestSubstringBrute("abcabcbb"));
        Assertions.assertEquals(1, lengthOfLongestSubstringBrute("bbbbb"));
        Assertions.assertEquals(3, lengthOfLongestSubstringBrute("pwwkew"));

    }

}
