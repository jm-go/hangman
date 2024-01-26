package org.hangman.game;

import org.hangman.ui.Gallows;
import org.hangman.ui.PlayerInteraction;
import org.hangman.words.AdvancedWord;
import org.hangman.words.BeginnerWord;
import org.hangman.words.RegularWord;
import org.hangman.words.Word;

public class GameController {

    private PlayerInteraction commands;
    private Word currentWord;

    public GameController() {
        commands = new PlayerInteraction();
        String[] commandOptions = new String[]{"Play Beginner Level", "Play Regular Level", "Play Advanced Level", "Quit Game"};
        commands.setCommands(commandOptions);
    }

    /**
     * Starts the Hangman game, allowing the player to select a difficulty level.
     * Manages the game flow based on the player's choice, including starting the game at different
     * levels or quitting. Invalid inputs prompt for a correct selection.
     */
    public void startGame() {
        System.out.println("\nWelcome to Hangman!" + "\n");
        System.out.println("Please choose the level of difficulty:");

        while (true) {
            commands.printCommands();
            int intInput = commands.getIntegerInput();

            switch (intInput) {
                case 0:
                    startBeginnerGame();
                    break;
                case 1:
                    startRegularGame();
                    break;
                case 2:
                    startAdvancedGame();
                    break;
                case 3:
                    System.out.println("\nQuitting the game. Goodbye!");
                    return;
                default:
                    System.out.println("\nInvalid input. Please select a valid option.");
                    break;
            }
        }
    }

    /**
     * Initialises and starts a beginner-level Hangman game.
     * Selects a word from the BeginnerWord class, and then
     * transitions to the main gameplay loop.
     */
    private void startBeginnerGame() {
        System.out.println("\nStarting a Beginner game...\n");
        currentWord = new BeginnerWord();
        playGame();
    }

    /**
     * Initialises and starts a regular-level Hangman game.
     * Chooses a word from the RegularWord class, and then
     * proceeds to the main gameplay loop.
     */
    private void startRegularGame() {
        System.out.println("\nStarting a Regular game...\n");
        currentWord = new RegularWord();
        playGame();
    }

    /**
     * Initialises and starts an advanced-level Hangman game.
     * Selects a word from the AdvancedWord class, and then
     * transitions to the main gameplay loop.
     */
    private void startAdvancedGame() {
        System.out.println("\nStarting an Advanced game...\n");
        currentWord = new AdvancedWord();
        playGame();
    }

    /**
     * Manages the main gameplay loop of Hangman. Initialises the game state, processes player guesses,
     * and updates the game display until the game ends - by guessing the word correctly
     * or losing all lives.
     */
    private void playGame() {
        GameState gameState = new GameState(currentWord);
        HandleGuess handleGuess = new HandleGuess(gameState);

        Gallows.displayGallows(gameState.getPlayerLives());

        while (!gameState.checkProgress()) {
            gameState.displayGameStatus();
            char guessedLetter = commands.getLetterInput();
            handleGuess.validateGuess(guessedLetter);
            Gallows.displayGallows(gameState.getPlayerLives());
        }
        gameState.showEndGameMessage();
    }
}