package com;

public class LongestPalindrom {
    public static void main(String[] args) {

        String str = "forswissssssssiwsfor";

        System.out.println(longestPalindromeDp(str));

    }

    private static String longestPalindromeDp(String s) {
        String result = "";
        int len = 0;
        boolean[][] isPali = new boolean[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || isPali[i + 1][j - 1])) {
                    isPali[i][j] = true;
                    if (j - i + 1 > len) {
                        result = s.substring(i, j + 1);
                        len = j - i + 1;
                    }
                }
            }
        }
        return result;
    }

    private static String longestPalindrom(String str) {
        if (null == str || str.length() == 0) return "";
        if (str.length() == 1) return str;

        int len = str.length();
        String longest = str.substring(0, 1);

        for (int i = 0; i < len - 1; i++) {

            String palindrome = expandRange(str, i, i);
            if (palindrome.length() > longest.length()) {
                longest = palindrome;
            }

            palindrome = expandRange(str, i, i + 1);
            if (palindrome.length() > longest.length()) {
                longest = palindrome;
            }

        }
        return longest;

    }
    public static String longestPalindrome(String s) {
        if (s == null || s.trim().equals("")) {
            return s;
        }
        int len = s.length();
        int begin = 0;
        int maxLen = 0;
        for (int i = 0; i < len - maxLen / 2; i++) { //n
            int j = i;
            int k = i;
            while (k < len - 1 && s.charAt(k) == s.charAt(k + 1)) { // Skip duplicated characters to the right
                k++;
            }
            while (j > 0 && k < len - 1 && s.charAt(j-1) == s.charAt(k+1)) { // Expand both left and right
                j--;
                k++;
            }
            int newLen = k - j + 1;
            if (newLen > maxLen) {
                begin = j;
                maxLen = newLen;
            }
        }
        return s.substring(begin, begin + maxLen);
    }
    private static String expandRange(String str, int left, int right) {
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return str.substring(left + 1, right);
    }
}
