package com;

public class PracticeSession {
    public static boolean isEmpty(String s) {
        return s == null || s.length() == 0;
    }

    public static String reverseString(String input) {
        return new StringBuilder(input).reverse().toString();
    }


    private static boolean longestPanlindrome(String substring, String reverse) {
        if (reverse.indexOf(substring) != -1) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] strings) {
        String input = "aacabdkacaa";
        String reverse = reverseString(input);
        String longestPalindrome = "";
        if (!isEmpty(input)) {
            for (int i = 0; i < input.length(); i++) {
                for (int j = i + 1; j <= input.length(); j++) {
                    String subStr = input.substring(i, j);
                    if (longestPanlindrome(subStr, reverse)) {
                        if (longestPalindrome.length() < subStr.length()) {
                            longestPalindrome = subStr;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        System.out.println("Longest Palindrome is " + longestPalindrome);
    }
}