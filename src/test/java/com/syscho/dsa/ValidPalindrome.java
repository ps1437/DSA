package com.syscho.dsa;

//https://leetcode.com/problems/valid-palindrome/
public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";

        System.out.println(isPalindrome(s.toLowerCase()));
        System.out.println(isPalindrome2(s.toLowerCase()));
        System.out.println(isPalindrome3(s.toLowerCase()));
    }

    private static boolean isPalindrome3(String s) {
        String str = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int end = str.length() - 1;
        for (int i = 0; i < str.length() / 2; i++,end--) {
            if (str.charAt(i) != str.charAt(end)) {
                return false;
            }

        }
        return true;
    }

    public static boolean isPalindrome2(String s) {

        int startIndex = 0;
        int lastIndex = s.length() - 1;

        while (startIndex < lastIndex) {

            char currentChar = s.charAt(startIndex);
            char lastChar = s.charAt(lastIndex);

            if (!Character.isLetterOrDigit(currentChar)) {
                startIndex++;

            } else if (!Character.isLetterOrDigit(lastChar)) {
                lastIndex--;

            } else {
                if (Character.toLowerCase(currentChar) != Character.toLowerCase(lastChar)) {

                    return false;
                }
                startIndex++;
                lastIndex--;
            }
        }


        return true;
    }

    public static boolean isPalindrome(String s) {

        String res = "";
        for (char c : s.toCharArray()) {

            if (Character.isAlphabetic(c) || Character.isDigit(c)) {

                res += c;
            }
        }

        StringBuilder stringBuilder = new StringBuilder(res);


        return stringBuilder.reverse().toString().equalsIgnoreCase(res);
    }
}
