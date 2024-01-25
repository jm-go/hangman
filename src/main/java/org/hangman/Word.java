package org.hangman;

public abstract class Word {

    /**
     * Abstract method to select a random word.
     * This needs to be implemented by all subclasses.
     *
     * @return A randomly selected word.
     */
    public abstract String selectRandomWord();
}
