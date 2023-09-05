package com.syscho.dsa.string;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

//https://www.geeksforgeeks.org/pangram-checking/
//A pangram is a sentence containing every letter in the English Alphabet. A-Z
public class PanagramChecking {


    @Test
    void test() {

        assertTrue(checkPangram("The Quick brown fox jumps over the lazy dog"));
        assertFalse(checkPangram("The quick brown fox jumps over the dog"));
        //Doesn’t contain all the characters from ‘a’ to ‘z’, as ‘l’, ‘z’, ‘y’ are missing

        assertTrue(checkPangram2("The quick brown fox jumps over the lazy dog")); //SEt
        assertFalse(checkPangram2("The quick brown fox jumps over the dog"));
        //Doesn’t contain all the characters from ‘a’ to ‘z’, as ‘l’, ‘z’, ‘y’ are missing
    }

    private boolean checkPangram2(String s) {

        Set<Character> arr = new HashSet<>();
        char[] chars = s.toCharArray();
        int index = 0;
        for (char ch : chars) {

            if (ch >= 'a' && ch <= 'z') {
                arr.add(ch);
            } else if (ch >= 'A' && ch <= 'Z') {
                ch = Character.toLowerCase(ch);
                arr.add(ch);
            }


        }

        return arr.size() == 26;
    }

    private boolean checkPangram(String s) {
        int arr[] = new int[26];

        char[] chars = s.toCharArray();
        int index = 0;
        for (char ch : chars) {

            if (ch >= 'a' && ch <= 'z') {
                index = ch - 'a';
            } else if (ch >= 'A' && ch <= 'Z') {
                index = ch - 'A';
            }

            arr[index] = 3;
        }

        for (int i = 0; i <= 25; i++)
            if (arr[i] != 3)
                return (false);

        return (true);
    }

    //Missing characters to make a string Pangram

    @Test
    void testMissingPanagram() {
        assertEquals("", checkPangramMissing("abcDefGHIJklmnopqrstuvwxyz"));
        assertEquals("def", checkPangramMissing("abcghijklmnopqrstuvwxyz"));

    }

    private String checkPangramMissing(String s) {
        boolean arr[] = new boolean[26];

        char[] chars = s.toCharArray();
        int index = 0;
        for (char ch : chars) {

            if (ch >= 'a' && ch <= 'z') {
                index = ch - 'a';
            } else if (ch >= 'A' && ch <= 'Z') {
                index = ch - 'A';
            }
            arr[index] = true;
        }

        String missing = "";
        for (int i = 0; i <= 25; i++)
            if (!arr[i]) {
                missing += (char) (i + 'a');
            }
        return missing;
    }


}
