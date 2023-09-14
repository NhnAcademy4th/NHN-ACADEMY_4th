package com.nhnacademy;

import static com.nhnacademy.ex4_3.pairDice;

public class ex4_4 {

    public static void main(String[] args) {
        double[] twoDice = new double[11];
        final int max_val = 10000;

        for(int i = 0; i < twoDice.length; i++){
            for(int j = 0; j < max_val;j++){
                twoDice[i] += pairDice(i+2);
            }
            twoDice[i] = twoDice[i] / max_val;
        }
        System.out.println("Total On Dice     Average Number of Rolls");
        System.out.println("-------------     -----------------------");
        for(int i = 0; i < twoDice.length; i++){
            System.out.printf("%5d                   %7.4f", (i+2), twoDice[i]);
            System.out.println(" ");

        }


    }
}
