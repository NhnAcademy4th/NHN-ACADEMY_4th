package com.nhnacademy.Chapter8;

import static com.nhnacademy.Chapter8.resources.InputShell.scannerClose;

import com.nhnacademy.Chapter8.resources.InputShell;


public class ex8_1 {
    public static double root( double A, double B, double C )
            throws IllegalArgumentException {
        if (A == 0) {
            throw new IllegalArgumentException("A can't be zero.");
        }
        else {
            double disc = B*B - 4*A*C;
            if (disc < 0)
                throw new IllegalArgumentException("Discriminant < zero.");
            return  (-B + Math.sqrt(disc)) / (2*A);
        }
    }

    //3개의 double형 변수를 선언하고 선업한 값을 root에 넣어줌
    private static double calculateRoot(){
        double firstNumber = inputDoubleShell();
        double secondNumber = inputDoubleShell();
        double thirdNumber = inputDoubleShell();

        double result = root(firstNumber,secondNumber,thirdNumber);
        return result;
    }

    //프로그램을 끝낼지 계속할지 판단하는 method
    private static boolean isStop(){
        String str = null;
        try{
            str = InputShell.inputFromShell("continue program? [Y|N]");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        str = str.toUpperCase();
        return (str.equals("YES") || str.equals("Y"));
    }
    public static double inputDoubleShell(){
        double doubleNumber = 0;
        try {
            doubleNumber = Double.parseDouble(InputShell.inputFromShell("Please Enter DobleNumber >>"));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return doubleNumber;
    }

    public static void main(String[] args) {
        do{
            System.out.println(calculateRoot());
        } while (isStop());

        scannerClose();
    }
}
