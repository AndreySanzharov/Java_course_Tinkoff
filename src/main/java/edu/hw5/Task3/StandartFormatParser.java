package edu.hw5.Task3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@SuppressWarnings({"MethodName", "UncommentedMain"})
public class StandartFormatParser {
    private StandartFormatParser() {
    }

    public static Optional<LocalDate> StandartparseDate(String dateString) {
        DateTimeFormatter[] formatters = {
            DateTimeFormatter.ofPattern("yyyy-MM-dd"),
            DateTimeFormatter.ofPattern("yyyy-MM-d"),
            DateTimeFormatter.ofPattern("d/M/yyyy"),
            DateTimeFormatter.ofPattern("d/M/yy"),
            DateTimeFormatter.ISO_LOCAL_DATE
        };

        for (DateTimeFormatter formatter : formatters) {
            try {
                LocalDate date = LocalDate.parse(dateString, formatter);
                return Optional.of(date);
            } catch (Exception e) {
            }
        }

        return Optional.empty();
    }

    @SuppressWarnings("RegexpSinglelineJava")
    public static void main(String[] args) {
        // Пример использования
        String dateString = "tomorrow";
        Optional<LocalDate> parsedDate = StandartparseDate(dateString);

        if (parsedDate.isPresent()) {
            System.out.println("Дата: " + parsedDate.get());
        } else {
            System.out.println("Невозможно распознать дату.");
        }
    }
}

