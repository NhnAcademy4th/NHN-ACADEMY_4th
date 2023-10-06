package com.nhnacademy.Chapter9;

import java.math.BigInteger;

public class ex9_1 {

    private static boolean isZero(BigInteger number) {
        return (number.equals(BigInteger.ZERO));
    }

    private static BigInteger fibonacci(BigInteger number) {
        boolean isFirstorsecond = (number.equals(BigInteger.ONE) || number.equals(BigInteger.TWO));
        if (isZero(number)) {
            return BigInteger.ZERO;
        }
        if (isFirstorsecond) {
            return BigInteger.ONE;
        }
        return fibonacci(number.subtract(BigInteger.ONE)).add(fibonacci(number.subtract(BigInteger.TWO)));
    }

    private static BigInteger factorial(BigInteger number) {
        if (isZero(number)) {
            return BigInteger.ONE;
        }
        return number.multiply(factorial(number.subtract(BigInteger.ONE)));
    }

    private static BigInteger selectMod(String init) {
        BigInteger inputNumber = null;
        BigInteger result;

        switch (init.toUpperCase()) {
            case "FACTORIAL": {
                try {
                    inputNumber = (new BigInteger(Inputshell.inputFromShell("Please input integer number >> ")));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                result = factorial(inputNumber);
            }
            break;
            case "FIBONACCI": {
                try {
                    inputNumber = (new BigInteger(Inputshell.inputFromShell("Please input integer number >> ")));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                result = fibonacci(inputNumber);
            }
            break;
            default: {
                throw new IllegalArgumentException("Please input Factorial or Fibonacci!");
            }
        }
        return result;
    }


    public static void main(String[] args) {
        String init = null;
        BigInteger result;

        initLine();
        try {
            init = Inputshell.inputFromShell("please input number >> ");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        result = selectMod(init);

        resultLine(result);
        Inputshell.scannerClose();
    }

    private static void resultLine(BigInteger value) {
        System.out.println("result : " + value);
    }

    private static void initLine() {
        System.out.println("Please enter function between Fibonacci or Factorial!");
    }

}
