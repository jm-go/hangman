package org.hangman.words;

import org.hangman.words.Word;

import java.util.Random;

public class AdvancedWord extends Word {

    private static final String[] words = {
            "Acceleration", "Biotechnology", "Consequential",
            "Encapsulation", "Fingerprint", "Gravitational",
            "Illumination", "Kaleidoscope", "Ornithology",
            "Photosynthesis", "Questionnaire", "Synchronization",
            "Boulevard", "Silhouette", "Misinterpretation",
            "Unpredictable", "Inconsequential", "Disproportionate",
            "Anthropologist", "Philosophical"
    };

    private static final int lives = 3;

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

    /**
     * Gets the number of lives for the advanced level of the game.
     * This level grants fewer lives due to higher difficulty.
     *
     * @return The fixed number of lives for advanced words, which is 3.
     */
    @Override
    public int getLives() {
        return lives;
    }
}