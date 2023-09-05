package com.syscho.dsa.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Longest Palindromic Substring
public class LongestPalindromeSubstring {


    static String bruteForce(String str) {
        // get length of input String
        int n = str.length();

        // All subStrings of length 1
        // are palindromes
        int maxLength = 1, start = 0;

        // Nested loop to mark start and end index
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                int flag = 1;

                // Check palindrome
                for (int k = 0; k < (j - i + 1) / 2; k++)
                    if (str.charAt(i + k) != str.charAt(j - k))
                        flag = 0;

                // Palindrome
                if (flag != 0 && (j - i + 1) > maxLength) {
                    start = i;
                    maxLength = j - i + 1;
                }
            }
        }

        String longPlainS = "";
        for (int i = start; i <= start + maxLength - 1; ++i)
            longPlainS += str.charAt(i);

        // return length of LPS
        return longPlainS;
    }


    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return s;
        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public String longestPalindromeIMP(String s) {

        if (null == s || s.length() == 0) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }

        int len = s.length();
        String longest = s.substring(0, 1);

        for (int i = 0; i < len - 1; i++) {

            String palindrome = expandRange(s, i, i);
            if (palindrome.length() > longest.length()) {
                longest = palindrome;
            }

            palindrome = expandRange(s, i, i + 1);
            if (palindrome.length() > longest.length()) {
                longest = palindrome;
            }

        }
        return longest;
    }

    private static String expandRange(String str, int left, int right) {
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return str.substring(left + 1, right);
    }

    @Test
    void paliTest() {
        assertEquals("geeksskeeg", bruteForce("forgeeksskeegfor"));//O(n^3).
        assertEquals("geeksskeeg", longestPalindrome("forgeeksskeegfor"));//O(n^3).
        assertEquals("geeksskeeg", longestPalindromeIMP("forgeeksskeegfor"));//O(n^3).

    }
}
