package com.nhnacademy.ch09;

import java.math.BigInteger;

/**
 * ex09_1
 */
public class ex09_1 {

    public static void main(String[] args) {
        System.out.println(factorial(BigInteger.valueOf(2L)));
        System.out.println(fibonacci(BigInteger.valueOf(10L)));
    }

    public static BigInteger factorial(BigInteger number) {
        if (number.signum() == -1)
            throw new IllegalArgumentException("factorial : number < 0");
        if (number.signum() == 0)
            return BigInteger.ONE;
        return number.multiply(factorial(number.subtract(BigInteger.ONE)));
    }

    public static BigInteger fibonacci(BigInteger number) {
        if (number.signum() == -1)
            throw new IllegalArgumentException("fibonacci : number < 0");
        if (number.signum() == 0)
            return BigInteger.valueOf(0);
        if (number.equals(BigInteger.ONE) || number.equals(BigInteger.TWO))
            return BigInteger.ONE;
        return fibonacci(number.subtract(BigInteger.ONE)).add(fibonacci(number.subtract(BigInteger.TWO)));
    }

}