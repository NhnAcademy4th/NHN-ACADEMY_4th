package ex5_3;

import ex5_1.*;
import ex5_2.*;

public class DiceSimulator {

    private DiceSimulator() {
    }

    private static StatCalc[] dicesStat;

    public static void dicesStatCalculate() {
        setStatCalc();
        int sum = 12;
        int times = 10000;

        for (int i = 1; i < sum; i++) {
            rollDice(dicesStat[i], i + 1, times);

            System.out.println("주사위 합계 : " + (i + 1));
            System.out.println(dicesStat[i]);
        }

    }

    public static void rollDice(StatCalc statCalc, int sum, int times) {
        for (int i = 0; i < times; i++) {
            statCalc.enter(RollDice.rollTo(sum));
        }
    }

    public static void setStatCalc() {
        dicesStat = new StatCalc[12];
        for (int i = 0; i < dicesStat.length; i++) {
            dicesStat[i] = new StatCalc();
        }
    }
}
