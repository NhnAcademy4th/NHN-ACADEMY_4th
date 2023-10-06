package com.nhnacademy.Chapter9.ex2;

import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        ScanFile.InsertData(Objects.requireNonNull(Main.class.getClassLoader().getResource("words.txt")).getFile());
        try {
            WriteFile.getSortedData("/words2.txt");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
