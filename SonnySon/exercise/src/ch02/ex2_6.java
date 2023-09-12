package ch02;

import java.util.Scanner;

public class ex2_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter your first name and last name, separated by a space.");
        System.out.print("?");

        String name = sc.nextLine();
        String firstName = name.substring(0, name.indexOf(" "));
        String lastName = name.substring(name.indexOf(" ") + 1);

        System.out.println("Your first name is " + firstName + ", which has " + firstName.length() + " characters.");
        System.out.println("Your last name is " + lastName + ", which has " + lastName.length() + " characters.");

        sc.close();
    }
}
