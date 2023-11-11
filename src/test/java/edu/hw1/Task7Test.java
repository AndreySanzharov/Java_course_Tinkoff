package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task7Test {
    @Test
    @DisplayName("Сдвиг вправо")
    public void Something(){
        assertEquals(4,Task7.rotateRight(8, 1));
    }
    @Test
    @DisplayName("Сдвиг влево")
    public void Something2(){
        assertEquals(1, Task7.rotateLeft(16, 1));
        assertEquals(6, Task7.rotateLeft(17, 2));
    }

}
