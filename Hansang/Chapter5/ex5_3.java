package com.nhnacademy.Chapter5;

import static com.nhnacademy.Chapter5.ex5_1.diceCompare;

public class ex5_3 {

    private static String[] dataSetMaker(String[] diceValue) {
        final int max_val = 10000;

        for (int i = 0; i < diceValue.length; i++) {
            StatCalc statCalc = new StatCalc();
            for (int j = 0; j < max_val; j++) {
                statCalc.enter(diceCompare(i + 2));
                diceValue[i] = statCalc.toString();
            }
        }
        return diceValue;
    }

    private static void testProblem3() {
        String[] diceValue = new String[11];
        dataSetMaker(diceValue);

        for (int i = 0; i < diceValue.length; i++) {
            lineInfomation(i);
            Resultprinter.resultLine(diceValue[i]);
        }
    }

    private static void lineInfomation(int indexNumber) {
        System.out.println("total value : " + (indexNumber + 2) + "  is....");
    }

    public static void main(String[] args) {
        testProblem3();
    }
}
