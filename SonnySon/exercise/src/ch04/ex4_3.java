package ch04;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ex4_3 {
    private static String EXPRESSION = "^[0-9]*$";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println(rollTheDice(sc.next()));
        snakeEyes();
        sc.close();
    }

    private static void snakeEyes() {
        int dice1;
        int dice2;
        int count = 0;

        do {
            count++;
            dice1 = (int) (Math.random() * 6 + 1);
            dice2 = (int) (Math.random() * 6 + 1);
        } while (dice1 != 1 && dice2 != 1);


        System.out.println(count);
    }

    public static int rollTheDice(String input) {
        if (!Pattern.matches(EXPRESSION, input))
            throw new IllegalArgumentException("ERROR : 숫자만 입력 가능합니다.");

        int value = Integer.parseInt(input);

        if (value > 12 || value < 2) {
            throw new IllegalArgumentException("ERROR : 두 주사위의 합 범위를 벗어납니다.(2~12)");
        }

        int count = 0;
        int sum;

        int a, b;

        do {
            count++;
            a = (int) (Math.random() * 6 + 1);
            b = (int) (Math.random() * 6 + 1);
            sum = a + b;
        } while (sum != Integer.parseInt(input));
        return count;
    }

    public static int rollTheDice(int value) {
        if (value > 12 || value < 2) {
            throw new IllegalArgumentException("ERROR : 두 주사위의 합 범위를 벗어납니다.(2~12)");
        }

        int count = 0;
        int sum;

        int a, b;

        do {
            count++;
            a = (int) (Math.random() * 6 + 1);
            b = (int) (Math.random() * 6 + 1);
            sum = a + b;
        } while (sum != value);
        return count;
    }
}
