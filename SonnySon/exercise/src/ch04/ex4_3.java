package ch04;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ex4_3 {
    private static String EXPRESSION = "^[0-9]*$";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int input;

        System.out.println(rollTheDice(sc.next()));
        snakeEyes();
    }

    private static void snakeEyes() {
        int dice1;
        int dice2;
        int count = 0;

        do {
            dice1 = (int) (Math.random() * 6 + 1);
            dice2 = (int) (Math.random() * 6 + 1);
            count++;
        } while (dice1 == 1 && dice2 == 1);

        System.out.println(count);
    }

    private static int rollTheDice(String input) {
        if (!Pattern.matches(EXPRESSION, input))
            throw new IllegalArgumentException("ERROR : 양의 정수만 입력 가능합니다.");

        int count = 0;
        int sum;

        do {
            sum = (int) (Math.random() * 6 + 1) + (int) (Math.random() * 6 + 1);
            count++;
        } while ((sum == Integer.parseInt(input)));
        return count;
    }
}
