package edu.hw2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {
    @Test
    @DisplayName("Константа")
    public void testConstant() {
        // Создаем экземпляр класса Constant с значением 5.0
        Task1.Constant constant = new Task1.Constant(5.0);
        // Проверяем, что метод evaluate() возвращает ожидаемое значение 5.0
        assertEquals(5.0, constant.evaluate(), 1e-6); // Сравнение с плавающей точкой
    }

    @Test
    @DisplayName("Отрицательное значение")
    public void testNegate() {
        // Создаем экземпляр класса Negate, который инвертирует значение 5.0
        Task1.Negate negate = new Task1.Negate(new Task1.Constant(5.0));
        // Проверяем, что метод evaluate() возвращает ожидаемое значение -5.0
        assertEquals(-5.0, negate.evaluate(), 1e-6);
    }

    @Test
    @DisplayName("Экспонента")
    public void testExponent() {
        Task1.Exponent exponent = new Task1.Exponent(new Task1.Constant(2.0), 3);
        assertEquals(8.0, exponent.evaluate(), 1e-6);
    }

    @Test
    @DisplayName("Сложение")
    public void testAddition() {
        Task1.Addition addition = new Task1.Addition(new Task1.Constant(3.0), new Task1.Constant(2.0));
        assertEquals(5.0, addition.evaluate(), 1e-6);
    }

    @Test
    @DisplayName("Умножение")
    public void testMultiplication() {
        // Создаем экземпляр класса Multiplication, который умножает 4.0 на 3.0
        Task1.Multiplication multiplication =
            new Task1.Multiplication(new Task1.Constant(4.0), new Task1.Constant(3.0));
        // Проверяем, что метод evaluate() возвращает ожидаемое значение 12.0
        assertEquals(12.0, multiplication.evaluate(), 1e-6);
    }
}
