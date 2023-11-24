package edu.hw7;

import edu.hw7.Task2.FactorialCalculator;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Task2Test {

    @Test
    public void testFactorial() {
        assertEquals(1, FactorialCalculator.factorial(0));
        assertEquals(1, FactorialCalculator.factorial(1));
        assertEquals(120, FactorialCalculator.factorial(5));
        assertEquals(3628800, FactorialCalculator.factorial(10));
        // Добавьте другие тестовые случаи по мере необходимости
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeFactorial() {
        FactorialCalculator.factorial(-5);
    }
}
