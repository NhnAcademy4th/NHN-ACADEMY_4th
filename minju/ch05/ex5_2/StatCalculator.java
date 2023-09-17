package ex5_2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StatCalculator {
    public static void startCalculate() {
        StatCalc calculator = new StatCalc();
        Scanner scanner = new Scanner(System.in);

        double number;

        while (true) {

            System.out.print("추가할 숫자를 입력해주세요. : ");

            try {
                number = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("숫자가 아닙니다. 다시 입력해주세요.");
                scanner.nextLine();
                continue;
            }

            if (number == 0) {
                System.out.println("계산을 종료합니다.");
                break;
            }

            calculator.enter(number);

        }

        scanner.close();
        System.out.println(calculator);

    }
}
