package ch02;

import java.util.Scanner;

public class ex2_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int quarters = sc.nextInt();
        int dimes = sc.nextInt();
        int nickels = sc.nextInt();
        int pennies = sc.nextInt();

        double dollars = (quarters * 0.25) + (dimes * 0.1) + (nickels * 0.05) + (pennies * 0.01);

        System.out.printf("%1.2", dollars);

        sc.close();
    }
}
