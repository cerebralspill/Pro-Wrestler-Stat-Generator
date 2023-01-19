package com.prowrestler.stats;

import com.prowrestler.dice.Dice6;
import java.util.ArrayList;
import java.util.List;

public class StatGenerator {

    public static List<Integer> rollStats() {
        System.out.println("Rolling dice");
        wait(500);
        System.out.println(".");
        wait(500);
        System.out.println(".");
        wait(500);
        System.out.println(".\n");
        wait(500);

        List<Integer> results = new ArrayList<>();

        //get all stats
        for (int i = 0; i < Wrestler.NUM_STATS; i++) {
            results.add(rollOneStat());
        }
        return results;
    }

    private static Integer rollOneStat() {
        Dice6 dice = new Dice6();
        List<Integer> rollResult = new ArrayList<>();
        //roll dice
        for (int i = 0; i < 4; i++) {
            rollResult.add(dice.roll());
        }

        //add all values
        int min = dice.getSides();
        Integer stat = 0;
        for (Integer num: rollResult) {
            if (min > num) min = num;
            stat += num;
        }

        return stat;

    }

    private static void wait(int ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
}
