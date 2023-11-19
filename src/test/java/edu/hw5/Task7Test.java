package edu.hw5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Task7Test {

    @Test
    void testFirstPatternMatching() {
        assertTrue(Task7.isMatchesFirst("010")); // Содержит не менее 3 символов, причем третий символ равен 0
        assertFalse(Task7.isMatchesFirst("01")); // Не содержит не менее 3 символов
    }

    @Test
    void testSecondPatternMatching() {
        assertTrue(Task7.isMatchesSecond("010")); // Начинается и заканчивается одним и тем же символом
        assertFalse(Task7.isMatchesSecond("110")); // Не заканчивается тем же символом
        assertFalse(Task7.isMatchesSecond("01")); // Не начинается и не заканчивается тем же символом
    }

    @Test
    void testThirdPatternMatching() {
        assertTrue(Task7.isMatchesThird("010")); // Длина не менее 1 и не более 3
        assertFalse(Task7.isMatchesThird("1100")); // Длина более 3
    }
}
