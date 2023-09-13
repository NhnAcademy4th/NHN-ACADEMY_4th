package ch02;

import java.util.Scanner;

public class ex_2_3_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Insert user name : ");
        String name = sc.next();
        System.out.println("Hello," + name.toLowerCase() + " nice to meet you!");
        System.out.println("Hello," + name.toUpperCase() + " nice to meet you!");

        sc.close();
    }
}
