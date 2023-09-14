package com.nhnacademy;

public class ex4_2 {

    private static String[] testcase = { "34A7", "ff8", "174204", "FADE", "ROg"};

    private static int[] solvecase = {13479,4088, 1524228,64222};
    public static int hTod(String str){
        int result = 0;
        int count = str.length() - 1;

        for(char c : str.toCharArray()){
            result+= (int) (hexaDecimal(c) * Math.pow(16, count));
            count--;
            }
            return result;
        }


    public static int hexaDecimal(char c){
            int number;

        switch (c) {
            case '0': number = 0;
                break;
            case '1': number = 1;
                break;
            case '2': number = 2;
                break;
            case '3': number = 3;
                break;
            case '4': number = 4;
                break;
            case '5': number = 5;
                break;
            case '6': number = 6;
                break;
            case '7': number = 7;
                break;
            case '8': number = 8;
                break;
            case '9': number = 9;
                break;
            case 'a':
            case 'A': number = 10;
                break;
            case 'b':
            case 'B': number = 11;
                break;
            case 'c':
            case 'C': number = 12;
                break;
            case 'd':
            case 'D': number = 13;
                break;
            case 'e':
            case 'E': number = 14;
                break;
            case 'f':
            case 'F': number = 15;
                break;
            default: number = -1;
                break;
        }
        if(number == -1) {
            throw new IllegalArgumentException("That's not hexadecimal number!");
        }else
            return number;
    }

    public static void solution(){
        for(int i = 0; i < testcase.length; i++) {
            System.out.println("hexadecimal to decimalnumber!");
            if (hTod(testcase[i]) == solvecase[i]){
                System.out.println("good!");
            }else{
                System.out.println("Convert fail!");
            }
        }
    }

    public static void main(String[] args) {
        solution();
    }




}
