package edu.hw1;

public class Task5 {
    // Функция для проверки, является ли число палиндромом или имеет палиндромного потомка
    public static String Descendant(int num) {
        String numStr = String.valueOf(num);
        StringBuilder descendant = new StringBuilder();
        // Создаем строку для потомка числа
        for (int i = 0; i < numStr.length() - 1; i += 2) {
            int digit1 = Character.getNumericValue(numStr.charAt(i));
            int digit2 = Character.getNumericValue(numStr.charAt(i + 1));
            descendant.append(digit1 + digit2);
        }

        numStr = descendant.toString(); // Заменяем исходное число на потомка
        String left = numStr;
        int numInt = Integer.parseInt(numStr);
        String right = new StringBuilder(numStr).reverse().toString();
        if (!left.equals(right)) {
            return Descendant(numInt);
        }
        return numStr;
    }

    public static boolean isPalindromeDescendant(String numStr) {
        String left = numStr;
        String right = new StringBuilder(numStr).reverse().toString();
        if (!left.equals(right)) {
            return false;
        }
        return true;
    }
}
