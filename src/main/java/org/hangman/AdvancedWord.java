package org.hangman;

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
}