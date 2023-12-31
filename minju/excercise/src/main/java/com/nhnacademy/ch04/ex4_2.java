package com.nhnacademy.ch04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex4_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("16진수를 입력해주세요 : ");
        String hex = br.readLine();
        try {
            System.out.println(hexToDecimal(hex));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        br.close();
    }

    public static int hexToDecimal(String str) {
        int value = 0;
        str = str.toUpperCase();

        for (int i = 0; i < str.length(); i++) {
            int hexValue = hexValue(str.charAt(i));
            value = value * 16 + hexValue;
        }

        return value;
    }

    public static int hexValue(char hex) {
        switch (hex) {
            case '0':
                return 0;
            case '1':
                return 1;
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            case 'A':
                return 10;
            case 'B':
                return 11;
            case 'C':
                return 12;
            case 'D':
                return 13;
            case 'E':
                return 14;
            case 'F':
                return 15;
            default:
                throw new IllegalArgumentException("16진수 형식에 맞지 않습니다.");
        }

    }
}
