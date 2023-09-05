package com.syscho.dsa.string;

import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringPatternMatching {

    boolean isDigits(String str) {
        //String regex = "\\d+";
        Pattern compile = Pattern.compile("[0-9]+");
        return compile.matcher(str).matches();
    }

    boolean isDigitsLoop(String str) {
        char[] chars = str.toCharArray();
        for (char ch :
                chars) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }

    boolean isAlpha(String str) {
        Pattern compile = Pattern.compile("[a-zA-Z]+");
        return compile.matcher(str).matches();
    }

    @Test
    void testIsDigit() {
        assertTrue(isDigits("12323"));
        assertTrue(isDigits("3123124124"));
        assertFalse(isDigits("rdasdf#s"));
        assertFalse(isDigits("das13214324"));
        assertFalse(isDigits("3123f23!"));
    }

    @Test
    void testIsDigitLoop() {
        assertTrue(isDigitsLoop("12323"));
        assertTrue(isDigitsLoop("3123124124"));
        assertFalse(isDigitsLoop("rdasdf#s"));
        assertFalse(isDigitsLoop("das13214324"));
        assertFalse(isDigitsLoop("3123f23!"));
    }

    @Test
    void testIsAlpha() {
        assertTrue(isAlpha("asdsdad"));
        assertTrue(isAlpha("asdasddasd"));

        assertFalse(isAlpha("ac23123"));
        assertFalse(isAlpha("aaa@#@a"));
        assertFalse(isAlpha("123!"));
    }
}
