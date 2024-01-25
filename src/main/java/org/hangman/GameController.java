package org.hangman;

import java.util.Collections;

public class GameController {

    private Commands commands;
    private Word currentWord;

    public GameController() {
        commands = new Commands();
        String[] commandOptions = new String[]{"Regular", "Advanced", "Quit"};
        commands.setCommands(commandOptions);
    }

    public void startGame() {
        System.out.println("\nWelcome to Hangman!");
        System.out.println("Please choose the level of difficulty:");

        while (true) {
            commands.printCommands();

            int intInput = commands.getIntegerInput();

            switch (intInput) {
                case 0:
                    startRegularGame();
                    break;
                case 1:
                    startAdvancedGame();
                    break;
                case 2:
                    System.out.println("\nQuitting the game. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid input. Please select a valid option.");
                    break;
            }
        }
    }

    private void startRegularGame() {
        System.out.println("\nStarting a regular game...\n");
        currentWord = new RegularWord();
        playGame();
    }

    private void startAdvancedGame() {
        System.out.println("\nStarting an advanced game...\n");
        currentWord = new AdvancedWord();
        playGame();
    }


    private void playGame() {
        GameState gameState = new GameState(currentWord);
        Gallows.displayGallows(gameState.getPlayerLives());
        boolean endOfGame = false;
        while (!endOfGame) {

            System.out.println("Mystery Word: " + gameState.getHiddenWord());
            Collections.sort(gameState.getGuessedLetters());
            System.out.println("Guessed letters: " + gameState.getGuessedLetters());
            char guessedLetter = commands.getLetterInput();

            if (gameState.getGuessedLetters().contains(guessedLetter)) {
                System.out.println("You have already guessed the letter: " + guessedLetter);
            } else {
                gameState.appendGuessedLetters(guessedLetter);

                if (gameState.getCurrentWord().contains(String.valueOf(guessedLetter))) {
                    String updatedHiddenWord = gameState.updateMysteryWord(
                            guessedLetter, gameState.getHiddenWord(), gameState.getCurrentWord());
                    gameState.setHiddenWord(updatedHiddenWord);

                    System.out.println("Correct guess!");
                } else {
                    gameState.decrementPlayerLives();
                    System.out.println("Incorrect guess. Lives remaining: " + gameState.getPlayerLives());
                }
            }
            Gallows.displayGallows(gameState.getPlayerLives());
            endOfGame = gameState.checkProgress();
        }


        gameState.showEndGameMessage();
    }
}