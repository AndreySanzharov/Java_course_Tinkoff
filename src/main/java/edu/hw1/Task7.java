package edu.hw1;

public class Task7 {

    public static int rotateRight(int n, int shift) {
        String binary = Integer.toBinaryString(n);
        int[] binaryList = new int[binary.length()];
        for (int i = 0; i < binary.length(); i++) {
            binaryList[(i + shift) % binary.length()] = Integer.parseInt(String.valueOf(binary.charAt(i)));
        }
        int count = binaryList.length - 1;
        int res = 0;
        for (int i = 0; i < binaryList.length; i++) {
            res += binaryList[i] * Math.pow(2, count);
            count--;
        }
        return res;
    }

    public static int rotateLeft(int n, int shift) {
        String binary = Integer.toBinaryString(n);
        int[] binaryList = new int[binary.length()];
        for (int i = 0; i < binary.length(); i++) {
            binaryList[((i - shift + 100000 * binaryList.length) % binaryList.length) % binary.length()] =
                Integer.parseInt(String.valueOf(binary.charAt(i)));
        }
        int count = binaryList.length - 1;
        int res = 0;
        for (int i = 0; i < binaryList.length; i++) {
            res += binaryList[i] * Math.pow(2, count);
            count--;
        }
        return res;
    }
}
