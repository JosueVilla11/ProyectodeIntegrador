package com.papasbrother.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsTest {
    @Test
    public void testFactorial() {
        assertEquals(1, MathUtils.factorial(0));
        assertEquals(1, MathUtils.factorial(1));
        assertEquals(120, MathUtils.factorial(5));
        assertThrows(IllegalArgumentException.class, () -> MathUtils.factorial(-1));
    }

    @Test
    public void testFibonacci() {
        assertEquals(0, MathUtils.fibonacci(0));
        assertEquals(1, MathUtils.fibonacci(1));
        assertEquals(5, MathUtils.fibonacci(5));
        assertEquals(21, MathUtils.fibonacci(8));
        assertThrows(IllegalArgumentException.class, () -> MathUtils.fibonacci(-2));
    }

    @Test
    public void testIsPrime() {
        assertFalse(MathUtils.isPrime(1));
        assertTrue(MathUtils.isPrime(2));
        assertTrue(MathUtils.isPrime(13));
        assertFalse(MathUtils.isPrime(15));
    }

    @Test
    public void testGcd() {
        assertEquals(6, MathUtils.gcd(54, 24));
        assertEquals(1, MathUtils.gcd(17, 31));
        assertEquals(10, MathUtils.gcd(0, 10));
    }
}
