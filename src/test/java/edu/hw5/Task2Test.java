package edu.hw5;

import edu.hw5.Task2;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {
    @Test
    @DisplayName("стандартный ввод")
    public void Test1() {
        List<LocalDate> expected = List.of(
            LocalDate.of(1925, 02, 13),
            LocalDate.of(1925, 03, 13),
            LocalDate.of(1925, 11, 13)
        );

        List<LocalDate> rez = Task2.findFridayThe13thsInYear(1925);
        assertEquals(expected, rez);
    }

    @Test
    @DisplayName("если year <= 0 то []")
    public void Test2() {
        List<LocalDate> expected = List.of();

        List<LocalDate> rez = Task2.findFridayThe13thsInYear(-1);
        assertEquals(expected, rez);
    }

    @Test
    @DisplayName("если year <= 0 то []")
    public void Test3() {
        List<LocalDate> expected = List.of();

        List<LocalDate> rez = Task2.findFridayThe13thsInYear(0);
        assertEquals(expected, rez);
    }
}

