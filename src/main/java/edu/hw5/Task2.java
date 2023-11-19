package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("MagicNumber")
public class Task2 {
    static int day = 13;
    static int month = 1;

    private Task2() {
    }

    public static List<LocalDate> findFridayThe13thsInYear(int year) {
        if (year <= 0) {
            return new ArrayList<>();
        }
        List<LocalDate> allFridayThe13ths = new ArrayList<>();

        LocalDate date = LocalDate.of(year, month, day);
        while (date.getYear() == year) {

            if (date.getDayOfWeek() == DayOfWeek.FRIDAY) {
                allFridayThe13ths.add(date);
            }
            date = date.plusMonths(1);
        }
        return allFridayThe13ths;
    }
}


