package com.nhnacademy.ch08.ex08_4;

import java.util.Scanner;

public class ex08_4 {
    public static void main(String[] args) {
        inputExpression();
    }

    public static void inputExpression() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter expression : ");
            String answer = scanner.nextLine().trim();

            if (answer.isEmpty())
                break;

            Expr expression;
            try {
                expression = new Expr(answer);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }

            while (true) {
                System.out.print("Enter variable value : ");
                answer = scanner.nextLine();
                if (answer.isEmpty())
                    break;
                try {
                    double result = expression.value(Double.parseDouble(answer));
                    if (Double.isNaN(result)) {
                        System.out.println("f(" + answer + ") is undefined.");
                    } else {
                        System.out.println("f(" + answer + ") = " + result);
                    }
                } catch (NumberFormatException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        System.out.println("종료합니다.");
    }
}
