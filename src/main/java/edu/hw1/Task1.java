package edu.hw1;

import java.util.Objects;

public final class Task1 {
    public static final int SIXTY = 60;

    public static int minutesToSeconds(String time) {
        if (Objects.isNull(time)) {
            return -1;
        }
        String[] parts = time.split(":");

        if (parts.length != 2 || time.isEmpty()) {
            return -1;
        }

        try {
            int minutes = Integer.parseInt(parts[0]);
            int seconds = Integer.parseInt(parts[1]);

            if (seconds >= SIXTY || seconds < 0 || minutes < 0) {
                return -1;
            }

            return minutes * SIXTY + seconds;
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
