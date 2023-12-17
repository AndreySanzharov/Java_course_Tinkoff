package edu.hw7;

import edu.hw7.Task4.MonteCarloPiThreads;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Task4Test {

    @Test
    void testCalculatePi() {
        MonteCarloPiThreads monteCarloPiThreads = new MonteCarloPiThreads(1000000, 4);
        double pi = monteCarloPiThreads.calculatePi();
        assertEquals(Math.PI, pi, 0.01);
    }

    @Test
    void testCountTotalPointsInsideCircle() {
        MonteCarloPiThreads monteCarloPiThreads = new MonteCarloPiThreads(1000000, 4);
        long pointsInsideCircleCount = monteCarloPiThreads.countTotalPointsInsideCircle();

        // Проверка, что количество точек внутри окружности неотрицательно
        assertEquals(true, pointsInsideCircleCount >= 0);
    }
    void testIsPointInsideCircle() {
        MonteCarloPiThreads monteCarloPiThreads = new MonteCarloPiThreads(1000000, 4);

        // Точка внутри окружности
        assertTrue(monteCarloPiThreads.isPointInsideCircle(0.5, 0.5));

        // Точка на границе окружности
        assertTrue(monteCarloPiThreads.isPointInsideCircle(1.0, 0.0));

        // Точка вне окружности
        assertFalse(monteCarloPiThreads.isPointInsideCircle(2.0, 2.0));
    }

    @Test
    void testCountPointsInsideCircle() {
        MonteCarloPiThreads monteCarloPiThreads = new MonteCarloPiThreads(1000000, 4);

        // Проверка, что количество точек внутри окружности неотрицательно
        assertTrue(monteCarloPiThreads.countPointsInsideCircle(100) >= 0);
    }

    @Test
    void testCalculatePiWithZeroTotalPoints() {
        MonteCarloPiThreads monteCarloPiThreads = new MonteCarloPiThreads(0, 4);

        // При нулевом общем количестве точек, результат должен быть NaN
        assertTrue(Double.isNaN(monteCarloPiThreads.calculatePi()));
    }
}
