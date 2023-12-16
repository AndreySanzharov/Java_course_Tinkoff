package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class Task6Test {
    @Test
    @DisplayName("Строка является подстрокой")
    public void Test1(){
        Task6 task6 = new Task6();
        assertTrue(task6.findSubString("abcdefg", "abc"));
    }
    @Test
    @DisplayName("Строка не является подстрокой")
    public void Test2(){
        Task6 task6 = new Task6();
        assertFalse(task6.findSubString("abcdefg", "iiii"));
    }
}
