package com.syscho.dsa.string;

//How do you reverse a given string in place?
//How can a given string be reversed using recursion?

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseString {

    String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    String reverse2(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            stringBuilder.append(str.charAt(i));
        }
        return stringBuilder.toString();
    }

    String reverse3(String str) {
        Stack<Character> stack = new Stack();
        for (Character ch : str.toCharArray()) {
            stack.push(ch);
        }
        String expected = "";
        while (!stack.empty()) {
            expected += stack.pop();
        }

        return expected;
    }

    String reverse4(String str) {
        int length = str.length();
        char[] chars = str.toCharArray();
        for (int i = 0; i < length / 2; i++) {
            //swap login first with last
            char left = chars[i];
            chars[i] = chars[length - 1 - i];
            chars[length - 1 - i] = left;

        }
        return new String(chars);
    }

    public static String reverse5(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        char[] characters = str.toCharArray();
        int i = 0;
        int j = characters.length - 1;
        while (i < j) {
            swap(characters, i, j);
            i++;
            j--;
        }
        return new String(characters);
    }

    private static void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }


    private String reverseRecursion(String str) {
        if (str.length() < 2) { //single and empty condition
            return str;
        }
        //ABC - > BC +a  - C+ b -> C - C+B+A
        return reverseRecursion(str.substring(1)) + str.charAt(0);
    }

    private String wordReverse(String sentence) {
        List<String> words = Arrays.asList(sentence.split("\\s"));
        Collections.reverse(words);
        StringBuilder sb = new StringBuilder(sentence.length());
        for (int i = 0; i < words.size(); i++) {
            sb.append(words.get(i));
            sb.append(' ');
        }
        return sb.toString().trim();

    }

    public static String wordReverse2(String sentence) {
        if (sentence.trim().isEmpty()) {
            return sentence;
        }
        StringBuilder reverse = new StringBuilder();
        String[] sa = sentence.trim().split("\\s");
        for (int i = sa.length - 1; i >= 0; i--) {
            reverse.append(sa[i]);
            reverse.append(' ');
        }
        return reverse.toString().trim();
    }


    @Test
    void testWordReverse() {
        assertEquals("world hello", wordReverse2("hello world"));
        assertEquals("world hello", wordReverse("hello world"));
    }


    @Test
    void testPalindrome() {
        assertEquals("aabbaa", wordReverse2("aabbaa"));
        assertEquals("acbcaa", wordReverse("acbcaa"));
    }

    @ParameterizedTest
    @CsvSource(value = {"hello,olleh", "wowww,wwwow", "Hi,iH"})
    void testReverse(String str, String expected) {
        assertEquals(expected, reverse(str));
        assertEquals(expected, reverse2(str));
        assertEquals(expected, reverse3(str));
        assertEquals(expected, reverse4(str));
        assertEquals(expected, reverse5(str));
        assertEquals(expected, reverseRecursion(str));
    }
}
