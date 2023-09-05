package com.syscho.dsa.string;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestWordinDictionary {


    static String findLogestWordDic(String s, List<String> dic) {

        String result = "";
        for (String str : dic) {
            if (isSubSequence(s, str)) {
                if (str.length() > result.length() || (str.length() == result.length() &&
                        str.compareTo(result) < 1)) {
                    result = str;
                }   //(N*X)
            }
        }
        return result;
    }

    static boolean isSubSequence(String str, String dic) {
        if (dic.length() > str.length()) return false;

        int i = 0, j = 0;
        while (i < str.length() && j < dic.length()) {
            if (str.charAt(i) == dic.charAt(j)) j++;
            i++;
        }
        return dic.length() == j;
    }

    @Test
    void test() {
        String str = "abpcplea";
        List<String> dictionary = List.of("ale", "apple", "monkey", "plea");
        String logestWordDic = LongestWordinDictionary.findLogestWordDic(str, dictionary);
        assertEquals("apple", logestWordDic);
    }
}
