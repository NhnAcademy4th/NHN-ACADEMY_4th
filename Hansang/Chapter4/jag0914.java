package com.nhnacademy;

import java.math.BigDecimal;

public class jag0914 {
        public static class Fraction {
            private int numerator;  // 분자
            private int denominator;    // 분모

            private boolean identifier;

            public Fraction(int numerator, int denominator, boolean negative) {
                this.numerator = numerator;
                this.denominator = denominator;
                this.identifier = negative;

                normalize();
            }

            public int getNumerator() {
                return numerator;
            }

            public boolean getIdentifier(){
                return identifier;
            }

            public void setNumerator(int numerator) {
                this.numerator = numerator;
            }

            public void setDenominator(int denominator) {
                this.denominator = denominator;
            }

            public int getDenominator() {
                return denominator;
            }

            public void normalize() {
                if(getDenominator() % getNumerator() ==0) {
                    setDenominator(getDenominator() / getNumerator());
                    setNumerator(getNumerator() / getNumerator());
                }
            }

            @Override
            public String toString() {
                if (identifier) {
                    return "Fraction{" + getNumerator()*-1 +
                            "/" + getDenominator() +
                            '}';
                }
                return "Fraction{" + getNumerator() +
                        "/" + getDenominator() +
                        '}';
            }
        }

        /**
         * 소수점 값에 대해 자리 수 계산 하는 메서드.    <br/>
         * ex)  <br/>
         * 0.01 -> 100을 곱하기 위해 2를 return    <br/>
         * 0.1 -> 10을 곱하기 위해 1을 return
         *
         *
         * @param num   소수 값
         * @return      소수점 이하 자리 수 값
         */
        public static int getDecimalNumber(BigDecimal num) {
            String str = num.toPlainString();
            int index = str.indexOf('.');
            int decimalNumber = Integer.parseInt(str.substring(index+1));

            return decimalNumber;
        }

        public static String solution(String input) {
            BigDecimal number = new BigDecimal(input);
            if(Double.parseDouble(input) > 1 || Double.parseDouble(input) < -1){
                throw new IllegalArgumentException("please enter bigger than -1 or smaller than 1");
            }


            int decimalNumber = getDecimalNumber(number);
            int whiledecimal = decimalNumber;


            double denominator = Math.pow(10, number.scale());
            int numerator = decimalNumber;

            return new Fraction(numerator, (int) denominator, isNegative(number)).toString();
        }

    private static boolean isNegative(BigDecimal input) {
        String str = input.toPlainString();
        if(str.contains("-")){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
            String input = "-0.2";
                System.out.println(solution(input));
        }

    }
