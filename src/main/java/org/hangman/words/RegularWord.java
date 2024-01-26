package org.hangman.words;

import java.util.Random;

public class RegularWord extends Word {

    private static final String[] WORDS = {
            "Balloon", "Elephant", "Flamingo",
            "Glitter", "Harmony", "Infinite",
            "Jigsaw", "Keyboard", "Lantern",
            "Mountain", "Necklace", "Octagon",
            "Painting", "Question", "Rainbow",
            "Sunlight", "Treasure", "Umbrella",
            "Volcano", "Whistle"
    };
    private static final int LIVES = 6;

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
     * @return The fixed number of lives for regular words (6).
     */
    @Override
    public int getLives() {
        return LIVES;
    }
}
