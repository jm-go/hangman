package org.hangman;

public abstract class Word {

    /**
     * Abstract method to select a random word.
     *
     * @return A randomly selected word.
     */
    public abstract String selectRandomWord();

    /**
     * Retrieves the number of player's lives based on the chosen difficulty level.
     *
     * @return The number of lives for the game.
     */
    public abstract int getLives();
}
