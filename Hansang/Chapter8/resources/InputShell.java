package com.nhnacademy.Chapter8.resources;

import java.util.Scanner;

public class InputShell {
    public static Scanner sc = new Scanner(System.in);
    public static String inputFromShell(String str) {
        System.out.print(str);
        String value  = sc.nextLine();
        return value;
    }

    public static void scannerClose(){
        sc.close();
    }


}
