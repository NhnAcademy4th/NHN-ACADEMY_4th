package chapter2.example;

import java.util.Scanner;

public class Ex2_3 {
    public static void main(String[] args) {
        System.out.printf("what's users name? : ");
        Scanner sc = new Scanner(System.in);
        String userName = sc.nextLine();
        System.out.printf("Hello, %s, nice to meet you!\n", userName.toUpperCase());
    }
}
