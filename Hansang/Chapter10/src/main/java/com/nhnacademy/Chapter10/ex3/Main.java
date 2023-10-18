package com.nhnacademy.Chapter10.ex3;

import com.nhnacademy.Chapter10.Inputshell;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        HashTable data = new HashTable(6);

        String key = null, value;
        Inputshell inputshell = new Inputshell();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("   1. test put(key,value)");
            System.out.println("   2. test get(key)");
            System.out.println("   3. test remove(key)");
            System.out.println("   4. EXIT");
            int number = 0;
            try {
                number = Integer.parseInt(inputshell.inputFromShell("Enter your command:  "));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

            switch (number) {
                case 1:
                    try {
                        key = inputshell.inputFromShell("\n   Key = ");
                        value = inputshell.inputFromShell("   Value = ");
                        data.put(key, value);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        key = inputshell.inputFromShell("\n   Key = ");
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("   Value is " + data.get(key));
                    break;
                case 3:
                    try {
                        key = inputshell.inputFromShell("\n   Key = ");
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                    data.remove(key);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("   Illegal command.");
                    break;
            }
            if (data != null) {
                System.out.println("\nHash table size is " + data.size());
            }
        }
    }
}
