package com.nhnacademy.ch02;

public class ex2_2_1 {

    public static void main(String[] args) {
        Dice firstDie = new Dice(6);
        Dice secondDie = new Dice(6);

        System.out.println("The first die comes up " + firstDie);
        System.out.println("The second die comes up " + secondDie);
        System.out.println("Your total roll is " + (firstDie.getValue() + secondDie.getValue()));
    }

}

class Dice {

    private int value;

    public Dice(int max) {
        this.value = (int) (Math.random() * max) + 1;
    }

    public int getValue() {
        return value;
    }
}
