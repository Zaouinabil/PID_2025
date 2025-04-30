package com.example.pid_2025.utils;

import java.text.Normalizer;
import java.util.Locale;
import java.util.regex.Pattern;

/**
 * A simple utility class to convert strings to URL-friendly slugs.
 */
public class Slugify {
    private static final Pattern NONLATIN = Pattern.compile("[^\\w-]");
    private static final Pattern WHITESPACE = Pattern.compile("[\\s]");

    /**
     * Convert a string to a slug by replacing spaces with hyphens,
     * removing special characters, and converting to lowercase.
     *
     * @param input The string to convert to a slug
     * @return The slugified string
     */
    public String slugify(String input) {
        if (input == null) {
            return "";
        }

        String nowhitespace = WHITESPACE.matcher(input).replaceAll("-");
        String normalized = Normalizer.normalize(nowhitespace, Normalizer.Form.NFD);
        String slug = NONLATIN.matcher(normalized).replaceAll("");
        return slug.toLowerCase(Locale.ENGLISH);
    }
}