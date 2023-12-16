package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task5Test {
    @Test
    @DisplayName("Верный формат")
    public void Test1() {
        Task5 task5 = new Task5();
        assertTrue(task5.CorrectNumber("А123ВЕ777"));
        assertTrue(task5.CorrectNumber("О777ОО177"));

    }
    @Test
    @DisplayName("Неверный формат")
    public void Test2() {
        Task5 task5 = new Task5();
        assertFalse(task5.CorrectNumber("123АВЕ777"));
        assertFalse(task5.CorrectNumber("А123ВГ77"));
        assertFalse(task5.CorrectNumber("А123ВЕ7777"));
    }
}
