package com.syscho.dsa.string;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

//https://www.geeksforgeeks.org/check-if-two-given-strings-are-isomorphic-to-each-other/
public class IsomorphicString {


    @Test
    void test() {

        assertTrue(isIsomorphic("aab", "xxy"));
        assertFalse(isIsomorphic("abb", "xxy"));

    }

    private boolean isIsomorphic(String str1, String str2) {

        if (str1.length() != str2.length()) return false;

        HashMap<Character, Character> charCount = new HashMap();
        for (int i = 0; i < str1.length(); i++) {
            char currentChar = str1.charAt(i);
            if (charCount.containsKey(currentChar)) {
                char c = charCount.get(currentChar);
                if (c != str2.charAt(i)) {
                    return false;
                }
            } else if (!charCount.containsValue(str2.charAt(i))) {
                charCount.put(currentChar, str2.charAt(i));
            } else {
                return false;
            }

        }


        return true;


    }
}
