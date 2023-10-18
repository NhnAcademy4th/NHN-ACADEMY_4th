package com.nhnacademy.Chapter10.ex6;

import com.nhnacademy.Chapter10.Inputshell;
import java.util.Objects;
import java.util.TreeMap;

public class Concordance {
    public static void main(String[] args) {
        TreeMap<String, WordData> word = new TreeMap<>();
        String path = (Objects.requireNonNull(Concordance.class.getClassLoader().getResource("shallow.txt")).getFile());
        word = ScanFile.InsertData(path);

        String inputword;
        Inputshell inputshell = new Inputshell();
        try {
            inputword = inputshell.inputFromShell("Enter word!");
            inputword = inputword.toLowerCase();
            if (word.containsKey(inputword)) {
                System.out.println(word.get(inputword));
            } else {
                System.out.println("invaild key!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
