package ch04;

import static ch04.ex4_3.rollTheDice;

public class ex4_4 {

    private static double calcDiceAver(int diceNum) {
        double sum = 0;

        for (int i = 0; i < 10000; i++) {
            sum += rollTheDice(diceNum);
        }

        return sum / 10000;
    }

    public static void main(String[] args) {
        System.out.println("Dice         Average");
        for (int i = 2; i <= 12; i++) {
            System.out.printf(i + "'s Average is %1.2f\n", calcDiceAver(2));
        }
    }
}
