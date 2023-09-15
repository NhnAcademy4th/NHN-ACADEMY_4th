package com.nhnacademy.Chapter5;

public class PairOfDice {

    private int dice1 = 0;
    private int dice2 = 0;

    public PairOfDice() {
        roll();
    }

    private void roll() {
        this.dice1 = (int) (Math.random()*6)+1;
        this.dice2 = (int) (Math.random()*6)+1;
    }

    public int getDice1() {
        return dice1;
    }

    public int getDice2() {
        return dice2;
    }

    public void setDice1() {
        this.dice1 = (int) (Math.random()*6)+1;
    }

    public void setDice2() {
        this.dice2 = (int) (Math.random()*6)+1;
    }

    @Override
    public String toString() {
        return "PairOfDice{" +
                "dice1=" + getDice1() +
                ", dice2=" + getDice2() +
                '}';
    }
}
