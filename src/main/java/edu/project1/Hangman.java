package edu.project1;

import java.util.Random;
import java.util.Scanner;
import static edu.project1.Dictionary.MAX_MISTAKES;
import static edu.project1.Dictionary.WORDS;

public class Hangman {
    String secretWord;

    char[] guessedWord;
    int mistakes;

    public Hangman() {
        secretWord = getRandomWord();
        guessedWord = new char[secretWord.length()];
        mistakes = 0;

        // Инициализируем guessedWord символами '*'.
        for (int i = 0; i < secretWord.length(); i++) {
            guessedWord[i] = '*';
        }
    }

    // Получение случайного слова из массива WORDS.
    public String getRandomWord() {
        Random random = new Random();
        int randomIndex = random.nextInt(WORDS.length);
        return WORDS[randomIndex];
    }

    @SuppressWarnings({"RegexpSinglelineJava", "MultipleStringLiterals", "MagicNumber"})
    public void playGame() {

        String miss = String.format("{Missed, mistake}");
        Scanner scanner = new Scanner(System.in);

        while (mistakes < MAX_MISTAKES) {
            System.out.println("The word: " + String.valueOf(guessedWord));
            System.out.print("Guess a letter: ");
            String input = scanner.nextLine();
            if (input.equals("surrender")) {
                mistakes = 4;
            } else if (input.length() != 1) {
                System.out.println("Please enter a single letter.");
                continue;
            }

            char guess = input.charAt(0);

            // Проверка, содержится ли буква в загаданном слове.
            if (secretWord.contains(String.valueOf(guess))) {
                updateGuessedWord(guess);
            } else {
                mistakes++;
                System.out.println(String.format("Missed, mistake %d out of %d.", mistakes, MAX_MISTAKES));
            }

            // Проверка, выиграл ли игрок.
            if (secretWord.equals(String.valueOf(guessedWord))) {
                System.out.println("The word: " + String.valueOf(guessedWord));
                System.out.println("You won!");
                break;
            }
        }

        // Если игрок исчерпал все попытки, выводим проигрыш и загаданное слово.
        if (mistakes >= MAX_MISTAKES) {
            System.out.println("You lost. The word was: " + secretWord);
        }
    }

    // Обновление угадываемого слова после успешной догадки игрока.
    public void updateGuessedWord(char guess) {
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == guess) {
                guessedWord[i] = guess;
            }
        }
    }

    @SuppressWarnings({"RegexpSinglelineJava", "UncommentedMain"})
    public static void main(String[] args) {
        Hangman game = new Hangman();
        System.out.println("Welcome to Hangman!");
        game.playGame();
    }
}
