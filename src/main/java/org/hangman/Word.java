package org.hangman;

import java.util.Random;

public class Word {

    private static final String[] regularLevel = {
            "Balloon", "Elephant", "Flamingo",
            "Glitter", "Harmony", "Infinite",
            "Jigsaw", "Keyboard", "Lantern",
            "Mountain", "Necklace", "Octagon",
            "Painting", "Question", "Rainbow",
            "Sunlight", "Treasure", "Umbrella",
            "Volcano", "Whistle"
    };

    private static final String[] advancedLevel = {
            "Acceleration", "Biotechnology", "Consequential",
            "Encapsulation", "Fingerprint", "Gravitational",
            "Illumination", "Kaleidoscope", "Ornithology",
            "Photosynthesis", "Questionnaire", "Synchronization",
            "Boulevard", "Silhouette", "Misinterpretation",
            "Unpredictable", "Inconsequential", "Disproportionate",
            "Anthropologist", "Philosophical"
    };

    public static String[] getRegularLevel() {
        return regularLevel;
    }

    public static String[] getAdvancedLevel() {
        return advancedLevel;
    }

    /**
     * Selects a random word from an array of words.
     *
     * @param words An array of words from which to select a random word.
     * @return A randomly selected word from the array.
     */
    public static String selectRandomWord(String[] words) {
        Random random = new Random();
        int randomIndex = random.nextInt(words.length);
        return words[randomIndex];
    }

}
