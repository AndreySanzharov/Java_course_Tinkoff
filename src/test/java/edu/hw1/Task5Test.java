package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task5Test {
    @Test @DisplayName("Числовые значения") public void numericValues() {
        assertEquals("11", Task5.Descendant(11211230));
        assertEquals("44", Task5.Descendant(13001120));
        assertEquals("5665", Task5.Descendant(23336014));
    }

    @Test @DisplayName("Срабатывание true и false") public void TrueOrFalse() {
        assertTrue(Task5.isPalindromeDescendant("11"));
        assertTrue(Task5.isPalindromeDescendant("44"));
        assertTrue(Task5.isPalindromeDescendant("5665"));

        assertFalse(Task5.isPalindromeDescendant("123"));
        assertFalse(Task5.isPalindromeDescendant("1234"));
    }

}
