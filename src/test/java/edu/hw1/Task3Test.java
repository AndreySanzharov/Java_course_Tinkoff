package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task3Test {
    @Test @DisplayName("Ответы true false") public void testIsNestable() {
        int[] a1 = {1, 2, 3, 4};
        int[] a2 = {0, 6};
        assertTrue(Task3.isNestable(a1, a2));

        int[] a3 = {3, 1};
        int[] a4 = {4, 0};
        assertTrue(Task3.isNestable(a3, a4));

        int[] a5 = {9, 9, 8};
        int[] a6 = {8, 9};
        assertFalse(Task3.isNestable(a5, a6));

        int[] a7 = {1, 2, 3, 4};
        int[] a8 = {2, 3};
        assertFalse(Task3.isNestable(a7, a8));
    }

    @Test @DisplayName("Минимальное значение") public void testFindMin() {
        int[] arr = {5, 2, 8, 1, 9};
        assertEquals(1, Task3.findMin(arr));

        int[] arr2 = {10, 15, 7, 12};
        assertEquals(7, Task3.findMin(arr2));
    }

    @Test @DisplayName("Максимальное значение") public void testFindMax() {
        int[] arr = {5, 2, 8, 1, 9};
        assertEquals(9, Task3.findMax(arr));

        int[] arr2 = {10, 15, 7, 12};
        assertEquals(15, Task3.findMax(arr2));
    }
}

