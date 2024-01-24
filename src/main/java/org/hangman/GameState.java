package org.hangman;

public class GameState {

    private String currentWord;
    private String hiddenWord;

    public GameState(String currentWord, String hiddenWord) {
        this.currentWord = currentWord;
        this.hiddenWord = hiddenWord;
    }

    /**
     * Generates a hidden version of the current word with underscores
     * to represent hidden letters, separated by spaces.
     *
     * @param word The current word.
     * @return A string with underscores to represent hidden letters.
     */
    private String generateHiddenWord(String word) {
        StringBuilder hiddenWord = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            hiddenWord.append("_");
            if (i < word.length() - 1) {
                hiddenWord.append(" ");
            }
        }
        return hiddenWord.toString();
    }
}
