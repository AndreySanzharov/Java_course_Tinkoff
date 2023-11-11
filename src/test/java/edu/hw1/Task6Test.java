package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task6Test {
    @Test
    @DisplayName("Шаги")
    public void Steps() {
        assertEquals(5, Task6.K(6621));
        assertEquals(4, Task6.K(6554));
        assertEquals(3, Task6.K(1234));
    }

    @Test
    @DisplayName("Сортировка")
    public void testSortDigits() {
        int ascending1 = Task6.sortDigits(3524, true);
        assertEquals(2345, ascending1);

        int descending1 = Task6.sortDigits(3524, false);
        assertEquals(5432, descending1);
    }

}
