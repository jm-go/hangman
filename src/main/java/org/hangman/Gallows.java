package org.hangman;

public class Gallows {

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

    public static String[] getGallows() {
        return gallows;
    }

    public static void setGallows(String[] gallows) {
        Gallows.gallows = gallows;
    }

    /**
     * Displays the gallows based on the player's remaining lives.
     *
     * @param playerLives The current number of player's remaining lives (0 to 6).
     */
    public static void displayGallows(int playerLives) {
        int index = 6 - playerLives;
        if (index < 0) {
            index = 0;
        }
        System.out.println(gallows[index]);
    }
}
