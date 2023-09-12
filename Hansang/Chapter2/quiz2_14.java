package com.Chapter2.Chapter2;

import java.util.Scanner;

public class quiz2_14 {
    public static void main(String[] args) {
        double num1;
        double num2;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter widget amount: ");
        num1 = sc.nextDouble();
        System.out.println("Enter widget's cost : ");
        num2 = sc.nextDouble();

        double totalCost = num1 * num2;
        System.out.printf("Total Cost of widget is %1.2f Won", totalCost);

        sc.close();
    }
}
