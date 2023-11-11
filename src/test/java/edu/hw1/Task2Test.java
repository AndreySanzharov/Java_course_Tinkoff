package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {
    @Test
    @DisplayName("Любые числа")
    public void CorrectItemsInput() {
        assertEquals(4, Task2.countDigits(1234));
        assertEquals(1, Task2.countDigits(0));
        assertEquals(3, Task2.countDigits(-123));
    }

    @Test
    @DisplayName("Число лонг формата")
    public void ebeb() {
        assertEquals(10, Task2.countDigits(3000000001L));
    }

}
