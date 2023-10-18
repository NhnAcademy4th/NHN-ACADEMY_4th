package com.nhnacademy.Chapter10.ex2;

import com.nhnacademy.Chapter10.Inputshell;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Inputshell inputshell = new Inputshell();
        String setNumbers = null;
        try {
            setNumbers = inputshell.inputFromShell("plase Enter set and operator : ");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        SetOperator setop = new SetOperator(setNumbers);
        setop.getResult();
        setop.showResult();

        inputshell.scannerClose();
    }

}
