package com.syscho.dsa.string;
//How do you print duplicate characters from a string? (solution)

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* * Find all duplicate characters in a String and print each of them. */


public class DuplicateChar {

    public static void printDuplicateCharacters(String word) {
        char[] characters = word.toCharArray();
        Map<Character, Integer> charMap = new HashMap<>();
        for (Character ch : characters) {
            if (charMap.containsKey(ch)) {
                charMap.put(ch, charMap.get(ch) + 1);
            } else {
                charMap.put(ch, 1);
            }

        }

        Set<Map.Entry<Character, Integer>> entrySet = charMap.entrySet();
        for (Map.Entry<Character, Integer> entry : entrySet) {
            if (entry.getValue() > 1) {
                System.out.printf("%s , count =  %d %n", entry.getKey(), entry.getValue());
            }
        }
    }

    static void fillCharCounts(String str, int[] count) {
        for (int i = 0; i < str.length(); i++)
            count[str.charAt(i)]++;
    }

    static void printDuplicateCharacters2(String str) {

        int count[] = new int[256];
        fillCharCounts(str, count);

        for (int i = 0; i < 256; i++)
            if (count[i] > 1)
                System.out.println((char) (i) +
                        ", count = " + count[i]);
    }

    public static void main(String[] args) {
        printDuplicateCharacters("Programming");
        printDuplicateCharacters2("Programming");

        printDuplicateCharacters("Combination");
        printDuplicateCharacters2("Combination");

        printDuplicateCharacters("Java");
        printDuplicateCharacters2("Java");
    }

}
