package com.Hansang;

import java.util.Scanner;

public class ex2_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("count change");
        System.out.println("please enter quarter : ");
        double quarter = sc.nextDouble();

        System.out.println("please enter dimes : ");
        double dimes = sc.nextDouble();

        System.out.println("please enter nickels : ");
        double nickels = sc.nextDouble();

        System.out.println("please enter pennies : ");
        double pennies = sc.nextDouble();

        System.out.println("You have " + ((quarter*0.25)+ (dimes*0.1)+(nickels*.05)+(pennies*0.01)) + " dollars");
    }
}
