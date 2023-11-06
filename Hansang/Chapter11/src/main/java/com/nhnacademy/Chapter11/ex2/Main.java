package com.nhnacademy.Chapter11.ex2;

import com.nhnacademy.Inputshell;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (Inputshell inputshell = new Inputshell()) {
            List<String> fileNames = new ArrayList<>();
            List<String> parsedText = new ArrayList<>();
            int count = 0;
            while (true) {
                fileNames.add(inputshell.inputFromShell("input file name : "));

                if (fileNames.get(count).equals("\n")) {
                    break;
                }

                count++;
            }

            for (int i = 0; i < fileNames.size(); i++) {
                System.out.print(fileNames.get(i) + ":  ");
                try {
                    parsedText = inputshell.parse(fileNames.get(i));
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                System.out.println(parsedText.size());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
