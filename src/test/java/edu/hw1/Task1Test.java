package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {
    @Test @DisplayName("Ввод строки верного формата") public void testValidInput() {
        assertEquals(60, Task1.minutesToSeconds("01:00"));
        assertEquals(836, Task1.minutesToSeconds("13:56"));
        assertEquals(0, Task1.minutesToSeconds("00:00"));
        assertEquals(3599, Task1.minutesToSeconds("59:59"));
    }

    @Test @DisplayName("Ввод строки неверного формата") public void testInvalidInput() {
        assertEquals(-1, Task1.minutesToSeconds("13:60")); // секунды >= 60
        assertEquals(-1, Task1.minutesToSeconds("abc:def")); // некорректный формат
        assertEquals(-1, Task1.minutesToSeconds("12:3a")); // некорректные числовые значения
        assertEquals(-1, Task1.minutesToSeconds("12:")); // недостаточное количество сегментов
        assertEquals(-1, Task1.minutesToSeconds("12:34:56")); // избыточное количество сегментов
        assertEquals(-1, Task1.minutesToSeconds("-5:30")); // отрицательные минуты
        assertEquals(-1, Task1.minutesToSeconds("5:-30")); // отрицательные секунды
    }

    @Test @DisplayName("Ввод строки null и пустой строки") public void empty() {
        assertEquals(-1, Task1.minutesToSeconds(null));
        assertEquals(-1, Task1.minutesToSeconds(""));
    }
}

