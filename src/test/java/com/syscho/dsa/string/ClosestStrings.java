package com.syscho.dsa.string;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

//https://www.geeksforgeeks.org/find-the-minimum-distance-between-the-given-two-words/
public class ClosestStrings {

    @Test
    void test() {
        String str[] = {"the", "quick", "brown", "fox", "quick"};
        String word1 = "the";
        String word2 = "fox";
        assertEquals(3, shortestDistance(str, word1, word2));
    }


    private int shortestDistance(String[] s, String word1, String word2) {

        int d1 = -1, d2 = -1;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < s.length; i++) {
            if (s[i] == word1)
                d1 = i;
            if (s[i] == word2)
                d2 = i;
            if (d1 != -1 && d2 != -1)
                ans = Math.min(ans, Math.abs(d1 - d2));
        }

        return ans;
    }
}

