package edu.hw7.Task2;

import java.util.stream.LongStream;

public class FactorialCalculator {
    private FactorialCalculator() {
    }

    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Факториал определен только для неотрицательных целых чисел");
        }

        return LongStream.rangeClosed(1, n).parallel().reduce(1, (a, b) -> a * b);
    }
}
