package com.nhnacademy.Chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class jag0915 {
    //Recursion factorial and fibonacci

    //switch case 문을 사용하지 않았을떄 사용
//    private static boolean isZero(int number){
//        return (number == 0);
//    }

    private static int fibonacci(int number){
//        boolean isFirstorsecond = (number == 1 || number == 2);
//        if(isZero(number)){
//            return 0;
//        }
//        if(isFirstorsecond){
//            return 1;
//        }
//        return fibonacci(number-1)+fibonacci(number-2);
//
        switch (number){
            case 0:
                return 0;
            case 1:
            case 2:
                return 1;
            default:
                return fibonacci(number-1)+fibonacci(number-2);
        }
    }

    private static int factorial(int number){
//        if(isZero(number)){
//            return 1;
//        }
//        return number * factorial(number -1);

        switch (number){
            case 0:
                return 1;
            default:
                return number * factorial(number -1);
        }
    }



    public static void main(String[] args) {
        String init = null;
        int inputNumber = 0;
        int result;

        initLine();
        try{
            init = Inputshell.inputFromshell();
        } catch (IOException e) {
            throw new IllegalArgumentException("Input error!");
        }

        switch (init) {
            case "Factorial":
            case "factorial": {
                middleLine();
                try {
                    inputNumber = Integer.parseInt(Inputshell.inputFromshell());
                } catch (IOException e) {
                    throw new NumberFormatException("Please input integer number!");
                }
                result = factorial(inputNumber);
                Resultprinter.resultLine(result);
            }
            break;
            case "Fibonacci":
            case "fibonacci": {
                middleLine();
                try {
                    inputNumber = Integer.parseInt(Inputshell.inputFromshell());
                } catch (IOException e) {
                    throw new NumberFormatException("Please input integer number!");
                }
                result = fibonacci(inputNumber);
                Resultprinter.resultLine(result);
            }
            break;
            default:
            {   throw new IllegalArgumentException("Please input Factorial or Fibonacci!");
            }
        }

    }


    private static void initLine(){
        System.out.println("Please enter function between Fibonacci or Factorial!");
    }

    private static void middleLine(){
        System.out.println("Please enter Integer number!");
    }


}
