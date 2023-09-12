package com.example.ch02;

import java.util.Scanner;

public class ex2_3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Insert user name : ");
        String name = sc.next();
        System.out.println("Hello," + name + " nice to meet you!");

        sc.close();
    }
}
