package org.hangman.ui;

public class Gallows {

    public static final String[] GALLOWS = {
            "        \n" +
                    "        \n" +
                    "        \n" +
                    "        \n" +
                    "        \n" +
                    "        \n" +
                    "=========\n",
            "+---+    \n" +
                    "|        \n" +
                    "|        \n" +
                    "|        \n" +
                    "|        \n" +
                    "|        \n" +
                    "=========\n",
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
     * @param playerLives The current number of player's remaining lives (0 to 8).
     */
    public static void displayGallows(int playerLives) {
        int index = 8 - playerLives;
        if (index < 0) {
            index = 0;
        }
        System.out.println(GALLOWS[index]);
    }
}
