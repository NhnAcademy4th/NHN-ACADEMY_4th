package com.nhnacademy.Chapter5;

public class ex5_2 {
    private static void makeDataSet(StatCalc statCalc) {
        double data;

        while (true) {
            try {
                data = Double.parseDouble(Inputshell.inputFromshell());
            } catch (Exception e) {
                throw new IllegalArgumentException("please enter double type number!");
            }

            boolean isZero = (data == 0);

            if (isZero) {
                Resultprinter.resultLine(statCalc.toString());
                return;
            }

            statCalc.enter(data);
        }


    }

    public static void main(String[] args) {
        StatCalc statcalc = new StatCalc();

        makeDataSet(statcalc);
    }

}
