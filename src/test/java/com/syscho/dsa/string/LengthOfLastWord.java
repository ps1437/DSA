package com.syscho.dsa.string;

//https://leetcode.com/problems/length-of-last-word/
public class LengthOfLastWord {
    public static void main(String[] args) {
        String s = "Hello World";

        System.out.println("   ddd d ".trim());

        String[] split = s.split("\\s");
        for (String s1 : split) {
            System.out.println(s1);
        }
        System.out.println(split[split.length - 1].length());

        System.out.println(lastWordLenght(s));
        System.out.println(lastWordLenght2(s));
    }

    private static int lastWordLenght2(String s) {
        s = s.trim();
        return s.length()-s.lastIndexOf(" ")-1;
    }

    private static int lastWordLenght(String s) {
        int lenght = 0;
        for (int i = s.length() - 1; i >= 0; i--) {

            if (s.charAt(i) != ' ') {
                lenght++;
            } else {

                if (lenght > 0) {
                    return lenght;
                }
            }

        }
        return lenght;
    }
}
