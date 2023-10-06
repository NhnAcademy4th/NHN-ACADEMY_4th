package ch09;

import java.math.BigInteger;
public class ex9_1 {
    public static BigInteger fibonacci(BigInteger value){
        if(value.equals(BigInteger.ZERO))
            return BigInteger.ZERO;
        else if(value.equals(BigInteger.ONE))
            return BigInteger.ONE;
        return fibonacci((value.subtract(BigInteger.ONE))).add(fibonacci(value.subtract(BigInteger.TWO)));
    }

    public static BigInteger factorial(BigInteger value){
        if(value.equals(BigInteger.ZERO)){
            return BigInteger.ONE;
        }
        return value.multiply(factorial(value.subtract(BigInteger.ONE)));
    }

    public static void main(String[] args) {
        BigInteger result = fibonacci(BigInteger.TEN);
        BigInteger factorialResult = factorial(BigInteger.TEN);

        System.out.println(result);
        System.out.println(factorialResult);
    }
}
