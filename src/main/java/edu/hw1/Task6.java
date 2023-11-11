package edu.hw1;

import java.util.Arrays;

public class Task6 {
    public static final int FINALITEM = 6174;

    public static int K(int num) {
        int steps = 0;
        while (num != FINALITEM) {
            int ascending = sortDigits(num, true);
            int descending = sortDigits(num, false);
            int result = descending - ascending;
            num = result;
            steps++;
        }
        return steps;
    }

    public static int sortDigits(int num, boolean ascending) {
        String numStr = String.valueOf(num);
        char[] digits = numStr.toCharArray();
        if (ascending) {
            Arrays.sort(digits);
        } else {
            Arrays.sort(digits);
            StringBuilder reversed = new StringBuilder(new String(digits));
            return Integer.parseInt(reversed.reverse().toString());
        }
        return Integer.parseInt(new String(digits));
    }
}

