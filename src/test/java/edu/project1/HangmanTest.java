package edu.project1;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HangmanTest {
    private Hangman game;

    @Before
    public void setup() {
        game = new Hangman();
    }

    @Test
    @DisplayName("победа")
    public void testWinGame() {
        game.secretWord = "hangman";
        game.guessedWord = "hangman".toCharArray();
        game.updateGuessedWord('h');
        game.updateGuessedWord('a');
        game.updateGuessedWord('n');
        game.updateGuessedWord('g');
        game.updateGuessedWord('m');
        game.updateGuessedWord('a');
        assertTrue(game.secretWord.equals(String.valueOf(game.guessedWord)));
    }

    @Test
    @DisplayName("поражение")
    public void testLoseGame() {
        game.secretWord = "word";
        game.mistakes = Dictionary.MAX_MISTAKES;
        game.playGame();
        assertTrue(game.mistakes >= Dictionary.MAX_MISTAKES);
    }

    @Test
    @DisplayName("получение случайного слова")
    public void testGetRandomWord() {
        String randomWord = game.getRandomWord();
        assertNotNull(randomWord);
        assertTrue(randomWord.length() > 0);
    }
}
