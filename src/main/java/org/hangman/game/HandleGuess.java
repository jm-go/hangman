package org.hangman.game;

import java.util.Collections;

public class HandleGuess {

    private GameState gameState;

    public HandleGuess(GameState gameState) {
        this.gameState = gameState;
    }

    /**
     * Validates the player's guessed letter.
     * Checks if the letter was already guessed, updates the game state,
     * and prints a message for the player.
     *
     * @param guessedLetter The letter guessed by the player.
     */
    public void validateGuess(char guessedLetter) {
        if (gameState.getGuessedLetters().contains(guessedLetter)) {
            System.out.println("\nYou have already guessed the letter: " + guessedLetter + "\n");
            return;
        }
        appendGuessedLetters(guessedLetter);

        if (gameState.getCurrentWord().contains(String.valueOf(guessedLetter))) {
            gameState.updateMysteryWord(guessedLetter, gameState.getHiddenWord(), gameState.getCurrentWord());
            System.out.println("\nCorrect guess! Lives remaining: " + gameState.getPlayerLives() + "\n");
        } else {
            gameState.decrementPlayerLives();
            System.out.println("\nIncorrect guess. Lives remaining: " + gameState.getPlayerLives() + "\n");
        }
    }

    /**
     * Appends a guessed letters array with new letters.
     *
     * @param letter The letter guessed by the player.
     */
    private void appendGuessedLetters(char letter) {
        if (!gameState.getGuessedLetters().contains(letter)) {
            gameState.getGuessedLetters().add(letter);
            Collections.sort(gameState.getGuessedLetters());
        }
    }
}
