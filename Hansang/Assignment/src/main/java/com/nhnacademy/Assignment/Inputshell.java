package com.nhnacademy.Assignment;

import java.util.Scanner;

public class Inputshell {
    private static Scanner sc = new Scanner(System.in);

    public static String inputFromShell(String str) {
        System.out.print(str);
        String value = sc.nextLine();
        value = value.stripLeading();
        return value;
    }

    public static void scannerClose() {
        sc.close();
    }
}
