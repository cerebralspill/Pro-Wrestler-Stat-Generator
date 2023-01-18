package com.prowrestler.dice;

import java.lang.Math;
public class Dice6 {
    private static final int SIDES = 6;

    public int getSides() {
        return this.SIDES;
    }

    public int roll() {
        int rolled = (int)(Math.random() * SIDES - 1 + 1) + 1;
        return rolled;
    }
}
