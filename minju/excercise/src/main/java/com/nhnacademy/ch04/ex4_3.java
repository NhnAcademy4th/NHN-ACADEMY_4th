package com.nhnacademy.ch04;

public class ex4_3 {

    public static int diceSum(int number) {

        if (number > 12 || number < 2) {
            throw new IllegalArgumentException("주사위의 합은 2보다 작을 수 없고, 12보다 클 수 없습니다.");
        }

        int count = 0;
        int sum;

        do {
            sum = rollTwoDice();
            count++;

        } while (sum != number);

        return count;
    }

    public static int rollTwoDice() {
        int dice1 = (int) (Math.random() * 6) + 1;
        int dice2 = (int) (Math.random() * 6) + 1;
        return dice1 + dice2;
    }

    public static void main(String[] args) {
        System.out.println(diceSum(2));
    }
}
