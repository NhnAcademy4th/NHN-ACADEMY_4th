package com.nhnacademy.algorithm;

import java.math.BigDecimal;

public class 소수분수변환 {

    public static class Fraction {
        private int numerator; // 분자
        private int denominator; // 분모

        public Fraction(int numerator, int denominator) {
            this.numerator = numerator;
            this.denominator = denominator;

            normalize();
        }

        public int getNumerator() {
            return numerator;
        }

        public int getDenominator() {
            return denominator;
        }

        public void normalize() {
            int divisor = gcd(numerator, denominator);
            numerator /= divisor;
            denominator /= divisor;
        }

        private int gcd(int x, int y) {
            if (y == 0)
                return x;
            return gcd(y, x % y);
        }

        @Override
        public String toString() {
            return numerator + "/" + denominator;
        }

    }

    /**
     * 소수점 값에 대해 자리 수 계산 하는 메서드. <br/>
     * ex) <br/>
     * 0.01 -> 100을 곱하기 위해 2를 return <br/>
     * 0.1 -> 10을 곱하기 위해 1을 return
     *
     * @param num 소수 값
     * @return 소수점 이하 자리 수 값
     */
    public static int getDecimalNumber(BigDecimal num) {
        String str = num.toPlainString();
        return str.substring(str.indexOf(".") + 1).length();
    }

    public static String solution(String input) {
        BigDecimal number = new BigDecimal(input);

        int decimalNumber = getDecimalNumber(number);

        double denominator = Math.pow(10, decimalNumber);
        int numerator = (int) (number.doubleValue() * denominator);

        return new Fraction(numerator, (int) denominator).toString();
    }

    private static final String[] TEST_CASES = {
            "0.1",
            "0.25",
            "0.000001"
    };

    private static final String[] TEST_CASE_RESULT = {
            "1/10",
            "1/4",
            "1/1000000"
    };

    public static void main(String[] args) {

        for (int i = 0; i < TEST_CASES.length; i++) {
            System.out.println("Test case" + (i + 1) + " = " + test(TEST_CASES[i], TEST_CASE_RESULT[i]));
        }
        System.out.printf("정답률 = %.3f%%", (correct / TEST_CASES.length * 100));

    }

    private static double correct = 0;

    public static boolean test(String input, String result) {
        if (solution(input).equals(result)) {
            correct++;
            return true;
        }
        return false;
    }
}