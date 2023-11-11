package edu.hw3;

public class Task4 {
    public static String convertToRoman(int num) {
        if (num < 1 || num > 3999) {
            return "Неверное число";
        }

        String[] romanNumerals = {
            "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
        };

        int[] values = {
            1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
        };

        StringBuilder roman = new StringBuilder();
        int i = 0;

        while (num > 0) {
            if (num >= values[i]) {
                roman.append(romanNumerals[i]);
                num -= values[i];
            } else {
                i++;
            }
        }
        return roman.toString();
    }
}
