package org.hangman;


public class GameController {

    private Commands commands;
    private int playerLives = 6;
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
        System.out.println("\nStarting a regular game...");
        currentWord = new RegularWord();
        playerLives = 6;
        playGame();
    }

    private void startAdvancedGame() {
        System.out.println("\nStarting an advanced game...");
        currentWord = new AdvancedWord();
        playerLives = 3;
        playGame();
    }

    private void playGame() {
        String wordToGuess = currentWord.selectRandomWord();
        Gallows.displayGallows(playerLives);

        // Add logic
    }
}