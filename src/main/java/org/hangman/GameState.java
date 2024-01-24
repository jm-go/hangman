package org.hangman;

public class GameState {

    private String currentWord;
    private String hiddenWord;
    private int playerLives;

    public GameState(String currentWord, String hiddenWord, int playerLives) {
        this.currentWord = currentWord;
        this.hiddenWord = hiddenWord;
        this.playerLives = playerLives;
    }

    public String getCurrentWord() {
        return currentWord;
    }

    public void setCurrentWord(String currentWord) {
        this.currentWord = currentWord;
    }

    public String getHiddenWord() {
        return hiddenWord;
    }

    public void setHiddenWord(String hiddenWord) {
        this.hiddenWord = hiddenWord;
    }

    public int getPlayerLives() {
        return playerLives;
    }

    public void setPlayerLives(int playerLives) {
        this.playerLives = playerLives;
    }

    /**
     * Generates a hidden version of the current word with underscores
     * to represent hidden letters, separated by spaces.
     *
     * @param word The current word.
     * @return A string with underscores to represent hidden letters.
     */
    public String generateMysteryWord(String word) {
        StringBuilder mysteryWord = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            mysteryWord.append("_");
            if (i < word.length() - 1) {
                mysteryWord.append(" ");
            }
        }
        return mysteryWord.toString();
    }

    // Add comment when logic has been tested
    public String updateMysteryWord(char letter, String mysteryWord, String currentWord) {
        char[] currentWordArray = currentWord.toCharArray();
        for (int i = 0; i < currentWordArray.length; i++) {
            if (currentWordArray[i] == letter) {
                char[] mysteryWordArray = mysteryWord.toCharArray();
                mysteryWordArray[i] = letter;
                return new String(mysteryWordArray);
            }
        }
        return mysteryWord;
    }

    public void trackProgress(int lives) {
        if (lives == 0) {
            //game over
        }
    }
}
