import org.hangman.game.GameState;
import org.hangman.game.HandleGuess;
import org.hangman.words.Word;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HandleGuessTest {

    private HandleGuess handleGuess;
    private GameState gameState;

    @BeforeEach
    void setUp() {
        gameState = new GameState(new Word() {
            @Override
            public String selectRandomWord() {
                return "MANGO";
            }

            @Override
            public int getLives() {
                return 8;
            }
        });
        handleGuess = new HandleGuess(gameState);
    }

    @Test
    @DisplayName("Guessing an already guessed letter does not affect player's lives.")
    void validateGuess_AlreadyGuessed_NoLivesLost() {
        handleGuess.validateGuess('A');
        handleGuess.validateGuess('A');
        assertEquals(8, gameState.getPlayerLives());
        assertTrue(gameState.getGuessedLetters().contains('A'));
    }

    @Test
    @DisplayName("Correct guess reveals the letter without losing a life.")
    void validateGuess_CorrectGuess_LetterRevealed() {
        handleGuess.validateGuess('A');
        assertEquals("_A___", gameState.getHiddenWord());
        assertEquals(8, gameState.getPlayerLives());
    }

    @Test
    @DisplayName("Incorrect guess decrements the number of lives.")
    void validateGuess_IncorrectGuess_LivesDecremented() {
        handleGuess.validateGuess('Z');
        assertEquals(7, gameState.getPlayerLives());
        assertTrue(gameState.getGuessedLetters().contains('Z'));
    }
}