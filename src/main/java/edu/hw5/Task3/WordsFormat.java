package edu.hw5.Task3;

import java.time.LocalDate;
import java.util.Optional;

@SuppressWarnings("MethodName")
public class WordsFormat {
    private WordsFormat() {
    }

    public static Optional<LocalDate> WordsparseDate(String dateString) {
        return switch (dateString) {
            case "today" -> Optional.of(LocalDate.now());
            case "tomorrow" -> Optional.of(LocalDate.now().plusDays(1));
            case "yesterday" -> Optional.of(LocalDate.now().minusDays(1));
            default -> Optional.empty();
        };
    }
}
