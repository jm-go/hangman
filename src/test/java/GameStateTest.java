import org.hangman.game.GameState;
import org.hangman.words.Word;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameStateTest {

    private GameState gameState;

    @BeforeEach
    void setUp() {
        Word testWord = new Word() {
            @Override
            public String selectRandomWord() {
                return "VOLCANO";
            }

            @Override
            public int getLives() {
                return 6;
            }
        };
        gameState = new GameState(testWord);
    }

    @Test
    @DisplayName("GameState initialises with correct word, lives, hidden word, and empty guessed letters.")
    void gameState_InitialisesCorrectly() {
        assertEquals("VOLCANO", gameState.getCurrentWord());
        assertEquals(6, gameState.getPlayerLives());
        assertEquals("_______", gameState.getHiddenWord());
        assertTrue(gameState.getGuessedLetters().isEmpty());
    }

    @Test
    @DisplayName("Decrementing player lives reduces the number of lives by one.")
    void decrementPlayerLives_WhenCalled_ReducesLives() {
        gameState.decrementPlayerLives();
        assertEquals(5, gameState.getPlayerLives());
    }

    @Test
    @DisplayName("Updating mystery word reveals correct letters for a correct guess.")
    void updateMysteryWord_CorrectLetterGuessed_RevealsCorrectLetters() {
        gameState.updateMysteryWord('O', gameState.getHiddenWord(), gameState.getCurrentWord());
        assertEquals("_O____O", gameState.getHiddenWord());
    }

    @Test
    @DisplayName("Check progress returns false at the initial state of the game.")
    void checkProgress_InitialState_ReturnsFalse() {
        assertFalse(gameState.checkProgress());
    }

    @Test
    @DisplayName("Returns true when the game ends and player wins.")
    void checkProgress_PlayerWins_ReturnsTrue() {
        gameState.updateMysteryWord('V', gameState.getHiddenWord(), gameState.getCurrentWord());
        gameState.updateMysteryWord('O', gameState.getHiddenWord(), gameState.getCurrentWord());
        gameState.updateMysteryWord('L', gameState.getHiddenWord(), gameState.getCurrentWord());
        gameState.updateMysteryWord('C', gameState.getHiddenWord(), gameState.getCurrentWord());
        gameState.updateMysteryWord('A', gameState.getHiddenWord(), gameState.getCurrentWord());
        gameState.updateMysteryWord('N', gameState.getHiddenWord(), gameState.getCurrentWord());
        assertTrue(gameState.checkProgress());
    }

    @Test
    @DisplayName("Returns true when the game ends and player loses.")
    void checkProgress_PlayerLoses_ReturnsTrue() {
        gameState.setPlayerLives(0);
        assertTrue(gameState.checkProgress());
    }
}