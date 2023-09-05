package com.syscho.dsa.string;
//https://www.geeksforgeeks.org/check-two-strings-k-anagrams-not/
//https://www.youtube.com/watch?v=VyQbl13RGiw
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class KAnagram {

    private boolean iAnagram(String s1, String s2, int k) {
        if (s1.length() != s2.length()) {
            return false;

        }
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < s1.length(); i++) {
            char ch = s2.charAt(i);
            if (map.getOrDefault(ch, 0) > 0) {
                map.put(ch, map.get(ch) - 1);
            }
        }

        int count = 0;
        for (char ch : map.keySet()) {
            count += map.get(ch);
        }

        if (count > k)
            return false;
        else
            return true;
    }


    private boolean iAnagram2(String s1, String s2, int k) {
        if (s1.length() != s2.length()) {
            return false;

        }
        int[] hash_str = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            hash_str[s1.charAt(i) - 'a']++;
        }
        int count = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (hash_str[s2.charAt(i) - 'a'] > 0) {
                hash_str[s2.charAt(i) - 'a']--;
            } else {
                count++;
            }
            if (count > k) {
                return false;
            }

        }
        return true;
    }

    @Test
    void testIsAnagram() {
        assertTrue(iAnagram("anagram", "grammar", 3)); //O(N) + SPACE o(N)
        assertFalse(iAnagram("geeks", "eggkf", 1));//O(N) + SPACE o(N)


        assertTrue(iAnagram("anagram", "grammar", 3)); //O(N) + SPACE o(1)
        assertFalse(iAnagram("geeks", "eggkf", 1));//O(N) + SPACE o(1)
    }


}
