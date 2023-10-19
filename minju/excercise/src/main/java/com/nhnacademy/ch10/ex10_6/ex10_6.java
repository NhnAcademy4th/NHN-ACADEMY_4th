package com.nhnacademy.ch10.ex10_6;

public class ex10_6 {
    public static void main(String[] args) {
        try {
            new ConcordanceReader(System.getProperty("user.dir") + "/ex10_6/test.txt")
                    .writeTextFile(System.getProperty("user.dir") + "/ex10_6/result.txt");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
