package com.nhnacademy.ch02;

import java.util.Scanner;

public class ex2_6 {
    public static void main(String[] args) {
        System.out.println("Please enter your first name and last name, separated by a space.");
        try(Scanner scanner = new Scanner(System.in)){
            String name = scanner.nextLine();

            String firstName = name.substring(0, name.indexOf(" "));
            String lastName = name.substring(name.indexOf(" ") + 1);

            System.out.println("Your first name is " + firstName + ", which has " + firstName.length() + " characters");
            System.out.println("Your last name is " + lastName + ", which has " + lastName.length() + " characters");
            System.out.println("Your initials are " + firstName.charAt(0) + lastName.charAt(0));
        }
    }
}
