package com.nhnacademy.ch08;

import java.math.BigInteger;
import java.util.Scanner;

public class ex08_2 {

    public static void main(String[] args) {
        System.out.print("숫자를 입력해주세요 : ");
        try (Scanner scanner = new Scanner(System.in)) {
            BigInteger number = new BigInteger(scanner.nextLine());
            collatz(number);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    static public BigInteger collatz(BigInteger n) {
        if (n.signum() == -1) {
            throw new IllegalArgumentException("음수는 사용할 수 없습니다.");
        }

        System.out.print(n + " ");

        if (n.signum() == 0 || n.equals(new BigInteger("1"))) {
            return n;
        }

        if (!n.testBit(0)) {
            return collatz(n.divide(new BigInteger("2")));
        }

        return collatz(n.multiply(new BigInteger("3")).add(new BigInteger("1")));
    }
}
