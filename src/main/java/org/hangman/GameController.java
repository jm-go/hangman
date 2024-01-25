package org.hangman;

public class GameController {

    private PlayerInteraction commands;
    private Word currentWord;

    public GameController() {
        commands = new PlayerInteraction();
        String[] commandOptions = new String[]{"Play Regular Level", "Play Advanced Level", "Quit Game"};
        commands.setCommands(commandOptions);
    }

    /**
     * Starts the Hangman game, allowing the player to select a difficulty level.
     * Manages the game flow based on the player's choice, including starting the game at different
     * levels or quitting. Invalid inputs prompt for a correct selection.
     */
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
                    System.out.println("\nInvalid input. Please select a valid option.");
                    break;
            }
        }
    }

    /**
     * Initialises and starts a regular-level Hangman game.
     * Chooses a word from the RegularWord class, and then
     * proceeds to the main gameplay loop.
     */
    private void startRegularGame() {
        System.out.println("\nStarting a regular game...\n");
        currentWord = new RegularWord();
        playGame();
    }

    /**
     * Initialises and starts an advanced-level Hangman game.
     * Selects a word from the AdvancedWord class, and then
     * transitions to the main gameplay loop.
     */
    private void startAdvancedGame() {
        System.out.println("\nStarting an advanced game...\n");
        currentWord = new AdvancedWord();
        playGame();
    }

    // Add comment when the function is refactored
    private void playGame() {
        GameState gameState = new GameState(currentWord);
        Gallows.displayGallows(gameState.getPlayerLives());
        boolean endOfGame = false;
        while (!endOfGame) {

            gameState.displayGameStatus();
            System.out.println();
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

                    System.out.println("Correct guess! Lives remaining: " + gameState.getPlayerLives() + "\n");
                } else {
                    gameState.decrementPlayerLives();
                    System.out.println("Incorrect guess. Lives remaining: " + gameState.getPlayerLives() + "\n");
                }
            }
            Gallows.displayGallows(gameState.getPlayerLives());
            endOfGame = gameState.checkProgress();
        }
        gameState.showEndGameMessage();
    }
}