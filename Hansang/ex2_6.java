package com.Hansang;

import java.util.Scanner;

public class ex2_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter your first name and last name, separated by a space.");
        System.out.print("?");
        String name = sc.nextLine();

        int num = name.indexOf(" ");
        String firstname = name.substring(0, num);
        String lastname  = name.substring(num+1);
        System.out.println("Your first name is " + firstname + ", which has " + firstname.length() +" characters" );
        System.out.println("Your last name is " + lastname + ", which has " + lastname.length() +" characters" );
        System.out.println("Your initials are " + firstname.substring(0,1)+lastname.substring(0,1) );

    }
}
