package edu.hw3;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task4Test {
    @Test
    @DisplayName("перевод числа в римскую цифру")
    public void items(){
        assertEquals("II", Task4.convertToRoman(2));
        assertEquals("XII", Task4.convertToRoman(12));
        assertEquals("XVI", Task4.convertToRoman(16));
    }
    @Test
    @DisplayName("Ошибки")
    public void error(){
        assertEquals("Неверное число", Task4.convertToRoman(0));
        assertEquals("Неверное число", Task4.convertToRoman(4000));
    }

}
