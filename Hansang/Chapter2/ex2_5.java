package com.Chapter2;


import java.util.Scanner;

public class ex2_5 {
    public static void main(String[] args) {
        int gross = 0;
        int dozen = 0;
        int remain = 0;

        Scanner sc = new Scanner(System.in);

        System.out.println("enter number : ");
        int number = sc.nextInt();

        gross = number / 144;

        number = number - (gross*144);

        dozen = number / 12;

        remain = number % 12;

        System.out.println("Your number of eggs is " + gross + " gross, " + dozen + " dozen, and " + remain);

    }
}
