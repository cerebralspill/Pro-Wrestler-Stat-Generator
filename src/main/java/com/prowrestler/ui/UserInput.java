package com.prowrestler.ui;

import com.prowrestler.stats.Wrestler;
import java.util.*;
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
            choice = input.nextLine().toLowerCase().trim();

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
    public static String getStatChoice(Wrestler stats, Integer stat) {

        String statChoice = "";
        boolean validInput = false;

        while (!validInput) {
            System.out.println("Where you would like to put [" + stat + "]");
            System.out.println("If a stat that is already filled is selected, you will be able to re-allocate the swapped out value");

            System.out.print("\nLooks");
            if (!stats.isStatEmpty("Looks")) System.out.print(" (Currently: " + stats.get("Looks") + ")");
            System.out.print("\nIn-ring Ability");
            if (!stats.isStatEmpty("In-ring Ability")) System.out.print(" (Currently: " + stats.get("In-ring Ability") + ")");
            System.out.print("\nFinishing Move");
            if (!stats.isStatEmpty("Finishing Move")) System.out.print(" (Currently: " + stats.get("Finishing Move") + ")");
            System.out.print("\nCharisma");
            if (!stats.isStatEmpty("Charisma")) System.out.print(" (Currently: " + stats.get("Charisma") + ")");
            System.out.print("\nMic Skills");
            if (!stats.isStatEmpty("Mic Skills")) System.out.print(" (Currently: " + stats.get("Mic Skills") + ")");
            System.out.print("\nTitles");
            if (!stats.isStatEmpty("Titles")) System.out.print(" (Currently: " + stats.get("Titles") + ")");

            System.out.print("\nEnter choice: ");
            statChoice = input.nextLine().trim().toUpperCase();
            statChoice = statChoice.substring(0, 3);
            if (stats.isValidStatType(statChoice)) validInput = true;
            if (!validInput) System.out.println("Error: unrecognized stat type");
        }

        return statChoice;
    }



}
