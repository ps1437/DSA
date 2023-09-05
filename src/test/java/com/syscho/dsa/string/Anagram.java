package com.syscho.dsa.string;
//How do you check if two strings are anagrams of each other?

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class Anagram {

    public boolean isAnagram(String word, String anagram) {
        if (word.length() != anagram.length()) {
            return false;

        }
        int[] freqs = new int[26];
        for (char c : word.toCharArray()) freqs[c - 'a']++;

        for (char c : anagram.toCharArray()) if (--freqs[c - 'a'] < 0) return false;
        return true;
    }

    private boolean iAnagram(String word, String anagram) {
        if (word.length() != anagram.length()) {
            return false;

        }
        char[] chars = word.toCharArray();
        for (char ch : chars) {
            int index = anagram.indexOf(ch);
            if (index != -1) {
                anagram = anagram.substring(0, index) + anagram.substring(index + 1);
            } else {
                return false;
            }
        }
        return anagram.isEmpty();
    }


    private boolean iAnagram2(String word, String anagram) {
        if (word.length() != anagram.length()) {
            return false;

        }
        StringBuilder stringBuilder = new StringBuilder(anagram);
        char[] chars = word.toCharArray();
        for (char ch : chars) {
            int index = stringBuilder.indexOf("" + ch);
            if (index != -1) {
                stringBuilder.deleteCharAt(index);
            } else {
                return false;
            }

        }
        return stringBuilder.isEmpty();
    }

    @Test
    void testIsAnagram() {
        assertTrue(iAnagram("word", "wrdo"));
        assertTrue(iAnagram("boat", "btoa"));
        assertTrue(iAnagram("a", "a"));

        assertFalse(iAnagram("pure", "in"));
        assertFalse(iAnagram("fill", "fil"));
        assertFalse(iAnagram("b", "bbb"));
        assertFalse(iAnagram("ccc", "ccccccc"));
        assertFalse(iAnagram("sleep", "slep"));


        assertTrue(iAnagram2("word", "wrdo"));
        assertTrue(iAnagram2("boat", "btoa"));
        assertTrue(iAnagram2("a", "a"));

        assertFalse(iAnagram2("pure", "in"));
        assertFalse(iAnagram2("fill", "fil"));
        assertFalse(iAnagram2("b", "bbb"));
        assertFalse(iAnagram2("ccc", "ccccccc"));
        assertFalse(iAnagram2("sleep", "slep"));

        assertFalse(isAnagram("pure", "in"));
        assertFalse(isAnagram("fill", "fil"));
        assertFalse(isAnagram("b", "bbb"));
        assertFalse(isAnagram("ccc", "ccccccc"));
        assertFalse(isAnagram("sleep", "slep"));
    }


}
