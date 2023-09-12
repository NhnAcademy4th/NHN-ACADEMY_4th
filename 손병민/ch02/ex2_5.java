package com.example.ch02;

import java.util.Scanner;

public class ex2_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input your eggs : ");

        int eggs = sc.nextInt();

        System.out.println("Your number of eggs is " + eggs / 144 + " gross, " + (eggs % 144) / 12 + " dozen, and "
                + (eggs % 144) % 12);

        sc.close();
    }
}
