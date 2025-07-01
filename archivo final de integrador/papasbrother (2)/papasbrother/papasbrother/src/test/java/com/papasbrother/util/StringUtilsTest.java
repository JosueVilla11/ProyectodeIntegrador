package com.papasbrother.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsTest {
    @Test
    public void testCapitalize() {
        assertEquals("Hola", StringUtils.capitalize("hola"));
        assertEquals("Hola mundo", StringUtils.capitalize("hola mundo"));
        assertNull(StringUtils.capitalize(null));
        assertEquals("", StringUtils.capitalize(""));
    }

    @Test
    public void testReverse() {
        assertEquals("odnum", StringUtils.reverse("mundo"));
        assertEquals("", StringUtils.reverse(""));
        assertNull(StringUtils.reverse(null));
    }

    @Test
    public void testCountWords() {
        assertEquals(2, StringUtils.countWords("hola mundo"));
        assertEquals(1, StringUtils.countWords("hola"));
        assertEquals(0, StringUtils.countWords("   "));
        assertEquals(0, StringUtils.countWords(null));
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(StringUtils.isPalindrome("Anita lava la tina"));
        assertFalse(StringUtils.isPalindrome("Hola mundo"));
        assertFalse(StringUtils.isPalindrome(null));
    }
}
