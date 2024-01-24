package org.hangman;

import java.util.ArrayList;

public class GameState {

    private String currentWord;
    private String hiddenWord;
    private ArrayList<Character> guessedLetters;

    public GameState(String currentWord, String hiddenWord, ArrayList<Character> guessedLetters) {
        this.currentWord = currentWord;
        this.hiddenWord = hiddenWord;
        this.guessedLetters = guessedLetters;
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


    public ArrayList<Character> getGuessedLetters() {
        return guessedLetters;
    }

    public void setGuessedLetters(ArrayList<Character> guessedLetters) {
        this.guessedLetters = guessedLetters;
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
        char[] mysteryWordArray = mysteryWord.toCharArray();
        for (int i = 0; i < currentWordArray.length; i++) {
            if (currentWordArray[i] == letter) {
                mysteryWordArray[i] = letter;
            }
        }
        return new String(mysteryWordArray);
    }

    // Add comment when logic is tested
    public void trackPlayerLives(int lives, boolean gameOver, boolean hasWon) {
        if (lives == 0) {
            gameOver = true;
        }
        if (!hiddenWord.contains("_")) {
            hasWon = true;
        }
    }

    /**
     * Appends a guessed letters array with new letters.
     *
     * @param letter The letter guessed by the player.
     */
    public void appendGuessedLetters(char letter) {
        if (!guessedLetters.contains(letter)) {
            guessedLetters.add(letter);
        }
    }
}
