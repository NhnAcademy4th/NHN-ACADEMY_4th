package com.nhnacademy.ch03;

import java.util.Scanner;

public class ex3_4 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("문장을 입력해주세요 : ");

        String sentence = scanner.nextLine();

        for (int i = 0; i < sentence.length(); i++) {
            char character = sentence.charAt(i);
            if (Character.isLetter(character)) {
                System.out.print(character);
            } else if (character == ' ') {
                System.out.println();
            }
        }
    }
}
