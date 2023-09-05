package com.syscho.dsa.string;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class FirstNonRepeatingChar {


    public static char firstNonRepeatingCharImp(String str) {
        char charaaray[] = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            int firstIndex = str.indexOf(charaaray[i]);
            int lastIndex = str.lastIndexOf(charaaray[i]);
            if (lastIndex == firstIndex)
                return charaaray[i];
        }
        return '-';
    }

    public static char getFirstNonRepeatedChar(String str) {
        Map<Character, Integer> counts = new LinkedHashMap<>(str.length());
        for (char c : str.toCharArray()) {
            counts.put(c, counts.containsKey(c) ? counts.get(c) + 1 : 1);
        }
        for (Entry<Character, Integer> entry : counts.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        throw new RuntimeException("didn't find any non repeated Character");
    }

    public static char firstNonRepeatingChar(String word) {
        Set<Character> repeating = new HashSet<>();
        List<Character> nonRepeating = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (repeating.contains(letter)) {
                continue;
            }
            if (nonRepeating.contains(letter)) {
                nonRepeating.remove((Character) letter);
                repeating.add(letter);
            } else {
                nonRepeating.add(letter);
            }
        }
        return nonRepeating.get(0);
    }

    @Test
    public void testFirstNonRepeatingCharImp() {
        assertEquals('b', firstNonRepeatingCharImp("abcdefghija"));
        assertEquals('h', firstNonRepeatingCharImp("hello"));
        assertEquals('J', firstNonRepeatingCharImp("Java"));
        assertEquals('i', firstNonRepeatingCharImp("simplest"));
    }

    @Test
    public void testFirstNonRepeatedCharacter() {
        assertEquals('b', getFirstNonRepeatedChar("abcdefghija"));
        assertEquals('h', getFirstNonRepeatedChar("hello"));
        assertEquals('J', getFirstNonRepeatedChar("Java"));
        assertEquals('i', getFirstNonRepeatedChar("simplest"));
    }

    @Test
    public void testFirstNonRepeatingChar() {
        assertEquals('b', firstNonRepeatingChar("abcdefghija"));
        assertEquals('h', firstNonRepeatingChar("hello"));
        assertEquals('J', firstNonRepeatingChar("Java"));
        assertEquals('i', firstNonRepeatingChar("simplest"));
    }


}
