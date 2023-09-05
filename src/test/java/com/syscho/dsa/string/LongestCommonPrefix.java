package com.syscho.dsa.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Longest Common Prefix using Sorting
public class LongestCommonPrefix {

    static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }

        }
        return prefix;
    }

    @Test
    void longestCommonPrefix() {
        assertEquals("fl", longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        assertEquals("flow", longestCommonPrefix(new String[]{"flow", "flower", "flower"}));
        assertEquals("", longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }
}
