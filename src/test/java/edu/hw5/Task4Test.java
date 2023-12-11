package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Task4Test {

    @Test
    @DisplayName("Содержит спец символ")
    void testPasswordWithSpecialSymbol() {
        Task4 task4 = new Task4();
        assertTrue(task4.CorrectOrNot("MyPassw0rd!"));
    }


    @Test
    @DisplayName("Пароль содержит несколько специальных символов")
    public void testPasswordWithMultipleSpecialSymbols() {
        Task4 task4 = new Task4();
        assertTrue(task4.CorrectOrNot("MyP@ssw0rd!"));
    }

    @Test
    @DisplayName("Пустой пароль")
    public void testEmptyPassword() {
        Task4 task4 = new Task4();
        assertFalse(task4.CorrectOrNot(""));
    }

    @Test
    @DisplayName("Пароль содержит пробел")
    public void testPasswordWithSpace() {
        Task4 task4 = new Task4();
        assertFalse(task4.CorrectOrNot("My Password"));
    }
}
