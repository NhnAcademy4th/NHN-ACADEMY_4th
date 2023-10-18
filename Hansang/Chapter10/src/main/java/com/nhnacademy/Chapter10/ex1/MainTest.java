package com.nhnacademy.Chapter10.ex1;

import com.nhnacademy.Chapter10.Inputshell;
import java.io.IOException;

public class MainTest {
    public static void main(String[] args) {
        Inputshell inputshell = new Inputshell();
        PhoneTreeMap ptm = new PhoneTreeMap();
        String name;

        while (true) {
            try {
                name = inputshell.inputFromShell("name : (press Enter exit program)");
                if ("\n".equals(name)) {
                    break;
                }
                String numbers = inputshell.inputFromShell("phone number : ");

                ptm.putNumber(name, numbers);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        }

        try {
            name = inputshell.inputFromShell("name get:");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(ptm.getNumber(name));

        inputshell.scannerClose();
    }
}
