package com.nhnacademy.ch05.ex5_1;

public class Dice {

    private int diceEye;

    public Dice(int maxDiceEye) {
        this.diceEye = (int) (Math.random() * maxDiceEye) + 1;
    }

    public int getDiceEye() {
        return this.diceEye;
    }

    @Override
    public String toString() {
        return String.valueOf(diceEye);
    }

}
