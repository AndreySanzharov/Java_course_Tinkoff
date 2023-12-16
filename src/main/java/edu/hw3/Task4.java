package edu.hw3;

import java.util.List;

public class Task4 {
    private Task4() {
    }

    @SuppressWarnings({"checkstyle:MagicNumber", "checkstyle:ParameterAssignment"})
    public static String convertToRoman(int num) {
        if (num < 1 || num > 3999) {
            return "Неверное число";
        }


        List<String> romanNumerals = List.of(
            "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I");

        List<Integer> values = List.of(
            1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1);

        StringBuilder roman = new StringBuilder();
        int i = 0;

        while (num > 0) {
            if (num >= values.get(i)) {
                roman.append(romanNumerals.get(i));
                num = num - values.get(i);
            } else {
                i++;
            }
        }
        return roman.toString();
    }
}
