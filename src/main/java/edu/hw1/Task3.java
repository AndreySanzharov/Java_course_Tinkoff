package edu.hw1;

public class Task3 {
    public static boolean isNestable(int[] a1, int[] a2) {
        if (a1.length == 0 || a2.length == 0) {
            return false;
        }

        int minA1 = findMin(a1);
        int maxA1 = findMax(a1);
        int minA2 = findMin(a2);
        int maxA2 = findMax(a2);

        return minA1 > minA2 && maxA1 < maxA2;
    }

    public static int findMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}

