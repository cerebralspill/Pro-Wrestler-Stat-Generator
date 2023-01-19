package com.prowrestler.ui;

import java.util.Scanner;

public class UserInput {

    private static Scanner input = new Scanner(System.in);

    public static String getGenericInput() {
        System.out.println("\nPress enter to continue");
        String userInput = input.nextLine();
        return userInput;
    }

    public static String getStatSortOption() {
        boolean validInput = false;
        String choice = "";

        while (!validInput) {
            System.out.println("Begin with (L)owest or (H)ighest stat: ");
            choice = input.nextLine();

            if (choice.equals("h")) {
                choice = "highest";
                validInput = true;
            } else if (choice.equals("l")) {
                choice = "lowest";
                validInput = true;
            } else {
                System.out.println("Error: Input cannot be read");
            }
        }
        return choice;
    }
}
