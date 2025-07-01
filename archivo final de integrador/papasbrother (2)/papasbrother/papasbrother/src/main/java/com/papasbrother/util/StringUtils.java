package com.papasbrother.util;

public class StringUtils {
    /**
     * Capitaliza la primera letra de una cadena.
     */
    public static String capitalize(String input) {
        if (input == null || input.isEmpty()) return input;
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }

    /**
     * Invierte una cadena de texto.
     */
    public static String reverse(String input) {
        if (input == null) return null;
        return new StringBuilder(input).reverse().toString();
    }

    /**
     * Cuenta las palabras en una cadena.
     */
    public static int countWords(String input) {
        if (input == null || input.trim().isEmpty()) return 0;
        return input.trim().split("\\s+").length;
    }

    /**
     * Verifica si una cadena es palíndromo.
     */
    public static boolean isPalindrome(String input) {
        if (input == null) return false;
        String clean = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return clean.equals(new StringBuilder(clean).reverse().toString());
    }
}
