package edu.hw7.Task4;

import java.util.concurrent.ThreadLocalRandom;

public class MonteCarloPi {

    public static double calculatePiSingleThreaded(int totalSimulations) {
        int circleCount = 0;

        for (int i = 0; i < totalSimulations; i++) {
            double x = ThreadLocalRandom.current().nextDouble();
            double y = ThreadLocalRandom.current().nextDouble();

            double distance = Math.sqrt(x * x + y * y);

            if (distance <= 1) {
                circleCount++;
            }
        }

        return 4.0 * circleCount / totalSimulations;
    }
}
