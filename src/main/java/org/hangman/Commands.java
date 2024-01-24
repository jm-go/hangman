package org.hangman;

import java.util.Scanner;

public class Commands {

    private Scanner scanner = new Scanner(System.in);

    private String[] commands;

    public String[] getCommands() {
        return commands;
    }

    public void setCommands(String[] commands) {
        this.commands = commands;
    }

    public void printCommands() {
        if (commands == null || commands.length == 0) {
            System.out.println("No current commands set.");
        } else {
//            System.out.println("Please select an option.");
            for (int i = 0; i < commands.length; i++) {
                System.out.println(i + ": " + commands[i]);
            }
        }
    }

    public Integer getIntegerInput() {
        while (true) {
            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();
                scanner.nextLine();
                if (input >= 0 && input < commands.length) {
                    return input;
                } else {
                    System.out.println("Invalid input. Please enter a number between 0 and " + (commands.length - 1) + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }
        }
    }

}
