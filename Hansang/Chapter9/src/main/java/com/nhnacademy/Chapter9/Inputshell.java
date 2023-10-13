package com.nhnacademy.Chapter9;

import java.util.Scanner;

public class Inputshell {
    private static Scanner sc = new Scanner(System.in);

    public static String inputFromShell(String str) {
        System.out.print(str);
        String value = sc.nextLine();
        value = value.stripLeading();
        if (value == "") {
            return "\n";
        }
        return value;
    }

    public static void scannerClose() {
        sc.close();
    }
}
