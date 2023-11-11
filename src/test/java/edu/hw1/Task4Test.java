package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task4Test {
    @Test @DisplayName("С текстом") public void WithText() {
        assertEquals("214365", Task4.fixString("123456"));
        assertEquals("This is a mixed up string.", Task4.fixString("hTsii  s aimex dpus rtni.g"));
        assertEquals("abcde", Task4.fixString("badce"));
    }

    @Test @DisplayName("Без текста") public void WithoutText() {
        assertEquals("", Task4.fixString(""));
        assertEquals(" ", Task4.fixString(" "));
    }

}
