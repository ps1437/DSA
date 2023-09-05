package com.syscho.dsa.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Rotation {

    boolean isRotated(String str, String rotated) {
        if (str.length() != rotated.length())
            return false;

        String newString = str + str;
        return newString.indexOf(rotated) == -1 ? false : true;
    }

    @Test
    void testRotated() {
        assertFalse(isRotated("abc", "aa"));
        assertTrue(isRotated("abc", "bca"));
        assertTrue(isRotated("abcdefg", "cdefgab"));
        assertFalse(isRotated("IndiaVsAustralia", "AustraliaVsIndia"));
        assertFalse(isRotated("abc", "ab"));
    }
}
