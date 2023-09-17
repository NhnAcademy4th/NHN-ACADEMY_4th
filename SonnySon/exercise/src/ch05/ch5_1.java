package ch05;

import ch05.resource.PairOfDice;

public class ch5_1 {
    public static void main(String[] args) {
        PairOfDice pairOfDice = new PairOfDice();

        int count = 0;

        do{
            pairOfDice.roll();
            count++;
        }while(pairOfDice.getDie1() != pairOfDice.getDie2());

        System.out.println(count);
    }
}