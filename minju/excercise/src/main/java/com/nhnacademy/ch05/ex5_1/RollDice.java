package com.nhnacademy.ch05.ex5_1;

public class RollDice {

    public static int rollTo(int number) {

        if (number < 2 || number > new PairOfDice().getMaxSum()) {
            throw new IllegalArgumentException("주사위의 합은 2보다 작을 수 없습니다.");
        }

        int count = 0;
        int sum;
        do {
            PairOfDice dices = new PairOfDice();
            sum = dices.sum();
            count++;
        } while (sum != number);

        return count;
    }

    public static void main(String[] args) {
        System.out.println(rollTo(2));
    }

}
