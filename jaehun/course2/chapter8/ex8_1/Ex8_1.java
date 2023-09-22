package course2.chapter8.ex8_1;

import java.util.Arrays;
import java.util.Scanner;

public class Ex8_1 {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        test();
        scanner.close();
    }

    public static void test() {
        System.out.println("이차방정식 해를 출력하는 프로그램입니다.");
        System.out.println("ax^2 + bx + c에서 a,b,c를 입력해주세요 (단, 입력은 실수만 가능) ");
        double[] doubles = inputFromShell();
        try {
            Equation equation = new Equation(doubles[0], doubles[1], doubles[2]);
            System.out.println(equation.root());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static double[] inputFromShell() {
        double[] doubles;
        while (true) {
            String input = scanner.nextLine();
            String[] splitedInput = input.split(" ");
            try {
                if (splitedInput.length != 3) {
                    throw new IllegalArgumentException("공백을 기준으로 세 실수를 입력해주세요.");
                }
                doubles = Arrays.stream(splitedInput).mapToDouble(Double::parseDouble).toArray();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return doubles;
    }
}
