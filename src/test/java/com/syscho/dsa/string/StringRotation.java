package com.syscho.dsa.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringRotation {

    static boolean rotationCompare(String str1, String str2, int rotate) {
        if (str1.length() != str2.length())
            return false;
        if (str1.length() < 2) {
            return str1.equals(str2);
        }
        String combinedStr = str1 + str1;
        int index = combinedStr.indexOf(str2);

        return index == rotate;
    }


    public static void main(String[] args) {
       boolean result = new StringRotation().rotationCompare("amazon","azonam",2);
        System.out.println(result);
    }

    @Test
    void test() {
        assertTrue(rotationCompare("amazon", "azonam", 2));
        assertFalse(rotationCompare("amazon", "azonam", 1));
    }
}
