package com.papasbrother.util;

import java.util.HashMap;
import java.util.Map;

public class MathUtils {
    /**
     * Calcula el factorial de un número de forma recursiva.
     */
    public static long factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("No se permite factorial de negativos");
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }

    /**
     * Calcula el n-ésimo número de Fibonacci de forma recursiva con memoización.
     */
    private static Map<Integer, Long> fibCache = new HashMap<>();
    public static long fibonacci(int n) {
        if (n < 0) throw new IllegalArgumentException("No se permite Fibonacci de negativos");
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (fibCache.containsKey(n)) return fibCache.get(n);
        long value = fibonacci(n - 1) + fibonacci(n - 2);
        fibCache.put(n, value);
        return value;
    }

    /**
     * Verifica si un número es primo.
     */
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    /**
     * Calcula el máximo común divisor (MCD) de dos números.
     */
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
