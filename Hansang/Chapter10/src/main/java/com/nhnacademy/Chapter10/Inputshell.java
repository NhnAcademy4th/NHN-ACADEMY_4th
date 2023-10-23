package com.nhnacademy.Chapter10;

import java.io.IOException;
import java.util.Scanner;

public class Inputshell {
    private Scanner sc = new Scanner(System.in);

    public String inputFromShell(String str) throws IOException {
        System.out.println(str);
        String value;
        try {
            value = sc.nextLine();
        } catch (Exception e) {
            throw new IOException();
        }
        value = value.stripLeading();
        if (value == "") {
            return "\n";
        }
        return value;
    }

    public void scannerClose() {
        sc.close();
    }
}
