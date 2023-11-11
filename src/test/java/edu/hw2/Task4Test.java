package edu.hw2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task4Test {
    @Test
    @DisplayName("Имя класса и метода")
    public void testCallingInfo() {
        Task4.CallingInfo callingInfo = Task4.callingInfo();
        // Замените "edu.hw2" на имя вашего пакета
        assertEquals("edu.hw2.Task4Test", callingInfo.className());
        assertEquals("testCallingInfo", callingInfo.methodName());
    }
}
