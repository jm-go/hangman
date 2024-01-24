package org.hangman;

public class Gallows {

    public static String[] getGallows() {
        return gallows;
    }

    public static void setGallows(String[] gallows) {
        Gallows.gallows = gallows;
    }

    public static String[] gallows = {
            "+---+    \n" +
                    "|   |    \n" +
                    "|       \n" +
                    "|       \n" +
                    "|       \n" +
                    "|       \n" +
                    "=========\n",

            "+---+    \n" +
                    "|   |    \n" +
                    "|   O    \n" +
                    "|       \n" +
                    "|       \n" +
                    "|       \n" +
                    "=========\n",

            "+---+    \n" +
                    "|   |    \n" +
                    "|   O    \n" +
                    "|   |    \n" +
                    "|       \n" +
                    "|       \n" +
                    "=========\n",

            "+---+    \n" +
                    "|   |    \n" +
                    "|   O    \n" +
                    "|  /|    \n" +
                    "|       \n" +
                    "|       \n" +
                    "=========\n",

            "+---+    \n" +
                    "|   |    \n" +
                    "|   O    \n" +
                    "|  /|\\   \n" +
                    "|       \n" +
                    "|       \n" +
                    "=========\n",

            "+---+    \n" +
                    "|   |    \n" +
                    "|   O    \n" +
                    "|  /|\\   \n" +
                    "|  /    \n" +
                    "|       \n" +
                    "=========\n",

            "+---+    \n" +
                    "|   |    \n" +
                    "|   O    \n" +
                    "|  /|\\   \n" +
                    "|  / \\   \n" +
                    "|       \n" +
                    "=========\n"
    };

    /**
     * Displays the gallows based on the player's remaining lives.
     *
     * @param gallows     An array of gallows illustrations representing different stages of the game.
     * @param playerLives The current number of player's remaining (0 to 6).
     */
    public static void displayGallows(String[] gallows, int playerLives) {
        int index = 6 - playerLives;
        if (index < 0) {
            index = 0;
        }
        System.out.println(gallows[index]);
    }
}
