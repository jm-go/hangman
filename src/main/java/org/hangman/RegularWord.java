package org.hangman;

import java.util.Random;

public class RegularWord extends Word {

    private static final String[] words = {
            "Balloon", "Elephant", "Flamingo",
            "Glitter", "Harmony", "Infinite",
            "Jigsaw", "Keyboard", "Lantern",
            "Mountain", "Necklace", "Octagon",
            "Painting", "Question", "Rainbow",
            "Sunlight", "Treasure", "Umbrella",
            "Volcano", "Whistle"
    };

    private static final int lives = 6;

    /**
     * Selects a random word from an array of words.
     *
     * @return A randomly selected word from the array.
     */
    @Override
    public String selectRandomWord() {
        Random random = new Random();
        int randomIndex = random.nextInt(words.length);
        return words[randomIndex];
    }


    // Add comment
    @Override
    public int getLives() {
        return lives;
    }
}
