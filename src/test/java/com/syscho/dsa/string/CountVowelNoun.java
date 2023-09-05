package com.syscho.dsa.string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

//How do you count a number of vowels and consonants in a given string
public class CountVowelNoun {

    String[] countVowelNoun(String str) {

        String vowels = "aeiouAEIOU";
        char[] chars = str.toCharArray();
        String vowelss = "";
        String noun = "";
        for (char ch : chars) {

            if (vowels.indexOf(ch) != -1) {
                vowelss += ch;
            } else {
                noun += ch;
            }

        }
        return new String[]{
                vowelss, noun
        };
    }

    @ParameterizedTest
    @CsvSource(value = {"abcdefg,bcdfg,ae"})
    void testCountVowelNoun(String str, String expectedNoun, String expectedVowles) {
        String[] res = countVowelNoun(str);
        String v = res[0];
        String n = res[1];

        assertEquals(expectedVowles, v);
        assertEquals(expectedNoun, n);
    }
}
