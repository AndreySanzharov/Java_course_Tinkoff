package edu.hw3;

public class Task1 {
    private Task1() {
    }

    public static String atbash(String text) {
        StringBuilder encryptedText = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char originalChar = text.charAt(i);
            char encryptedChar = originalChar;

            if (Character.isLetter(originalChar)) {
                if (Character.isUpperCase(originalChar)) {
                    encryptedChar = (char) ('Z' - (originalChar - 'A'));
                } else {
                    encryptedChar = (char) ('z' - (originalChar - 'a'));
                }
            }
            encryptedText.append(encryptedChar);

        }
        return encryptedText.toString();
    }
}
