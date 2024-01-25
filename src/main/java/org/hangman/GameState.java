package org.hangman;

import java.util.ArrayList;

public class GameState {

    private String currentWord;
    private int playerLives;
    private String hiddenWord;
    private ArrayList<Character> guessedLetters;


    public GameState(Word currentWord) {
        this.currentWord = currentWord.selectRandomWord().toUpperCase();
        this.playerLives = currentWord.getLives();
        this.hiddenWord = generateMysteryWord(this.currentWord);
        this.guessedLetters = new ArrayList<>();
    }

    public int getPlayerLives() {
        return playerLives;
    }

    public void setPlayerLives(int playerLives) {
        this.playerLives = playerLives;
    }

    public String getCurrentWord() {
        return currentWord;
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

    /**
     * Decreases the number of lives the player has by one.
     * This method is only called when the player makes an incorrect guess.
     */
    public void decrementPlayerLives() {
        setPlayerLives(getPlayerLives() - 1);
    }

    /**
     * Generates a hidden version of the current word with underscores
     * to represent hidden letters, separated by spaces.
     *
     * @param word The current word.
     * @return A string with underscores to represent hidden letters.
     */
    private String generateMysteryWord(String word) {
        StringBuilder mysteryWord = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            mysteryWord.append("_");
            if (i < word.length() - 1) {
                mysteryWord.append(" ");
            }
        }
        return mysteryWord.toString();
    }

    /**
     * Updates the hidden word representation based on the player's correct guess.
     *
     * @param letter      The letter guessed by the player.
     * @param mysteryWord The current hidden representation of the word.
     * @param currentWord The actual word the player is trying to guess.
     * @return The updated hidden representation of the word.
     */
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

    /**
     * Checks the progress of the game to determine if it has ended.
     * The game ends either when the player runs out of lives or successfully guesses the word.
     *
     * @return true if the game is over, false otherwise.
     */
    public boolean checkProgress() {
        return getPlayerLives() <= 0 || !getHiddenWord().contains("_");
    }

    /**
     * Displays the end-game message, indicating whether the player won or lost.
     * Shows the correct word at the end of the game.
     */
    public void showEndGameMessage() {
        if (getPlayerLives() > 0) {
            System.out.println("Congratulations, you won! The word was: " + this.getCurrentWord());
        } else {
            System.out.println("Game over! The word was: " + this.getCurrentWord());
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
