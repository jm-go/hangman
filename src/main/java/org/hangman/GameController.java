package org.hangman;


public class GameController {

    private Commands commands;
    private int playerLives = 6;

    public GameController(Commands commands, int playerLives) {
        this.commands = commands;
        this.playerLives = playerLives;
    }

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

            if (intInput == 0) {
                System.out.println("\nStarting a regular game...");
                Word.selectRandomWord(Word.getRegularLevel());
                Gallows.displayGallows(playerLives);
            } else if (intInput == 1) {
                System.out.println("\nStarting an advanced game...");
                Word.selectRandomWord(Word.getAdvancedLevel());
            } else if (intInput == 2) {
                System.out.println("\nQuitting the game. Goodbye!");
                break;
            } else {
                System.out.println("Invalid input. Please select a valid option.");
            }
        }
    }
}