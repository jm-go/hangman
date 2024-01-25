package org.hangman.words;

import java.util.Random;

public class BeginnerWord extends Word {

    private static final String[] WORDS = {
            "Banana", "Circus", "Dragon",
            "Flower", "Genius", "Ghost",
            "Insect", "Jungle", "Kitten",
            "Lizard", "Marble", "Orange",
            "Ribbon", "Rabbit", "Sphere",
            "Tunnel", "Velvet", "Magic",
            "Mango", "Ocean"
    };
    private static final int LIVES = 8;

    /**
     * Selects a random word from an array of words.
     *
     * @return A randomly selected word from the array.
     */
    @Override
    public String selectRandomWord() {
        Random random = new Random();
        int randomIndex = random.nextInt(WORDS.length);
        return WORDS[randomIndex];
    }

    /**
     * Gets the number of lives for the regular level of the game.
     *
     * @return The fixed number of lives for beginner words, which is 8.
     */
    @Override
    public int getLives() {
        return LIVES;
    }
}

