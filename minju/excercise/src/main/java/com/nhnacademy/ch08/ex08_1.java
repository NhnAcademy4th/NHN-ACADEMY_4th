package com.nhnacademy.ch08;

import java.util.Scanner;

/**
 * ex08_1
 */
public class ex08_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String answer = "";
        while (!answer.equals("no")) {
            try {

                System.out.print("Enter A : ");
                String inputA = scanner.nextLine();

                System.out.print("Enter B : ");
                String inputB = scanner.nextLine();

                System.out.print("Enter C : ");
                String inputC = scanner.nextLine();

                String check = "\\d+(.\\d+)?";
                if (!(inputA.matches(check) && inputB.matches(check) && inputC.matches(check))) {
                    System.out.println("값이 잘못 입력되었습니다. 다시 입력해주세요.");
                    continue;
                }

                double A = Double.parseDouble(inputA);
                double B = Double.parseDouble(inputB);
                double C = Double.parseDouble(inputC);
                System.out.println("result : " + root(A, B, C));

                System.out.print("종료하시겠습니까? (no 입력시 종료) : ");
                answer = scanner.nextLine().toLowerCase();

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }

    public static double root(double a, double b, double c)
            throws IllegalArgumentException {
        if (a == 0) {
            throw new IllegalArgumentException("A can't be zero.");
        } else {
            double disc = b * b - 4 * a * c;
            if (disc < 0)
                throw new IllegalArgumentException("Discriminant < zero.");
            return (-b + Math.sqrt(disc)) / (2 * a);
        }
    }
}
