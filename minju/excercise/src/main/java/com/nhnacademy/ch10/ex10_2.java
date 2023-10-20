package com.nhnacademy.ch10;

import java.util.*;

public class ex10_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("집합 2개를 입력해주세요 : ");
                String line = scanner.nextLine();
                if (line.isEmpty())
                    break;
                System.out.println(parseInputSets(line));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }

    private static final String SET_REGEX = "^\\[(\\d+,?)+\\][*+-]\\[(\\d+,?)+\\]$";

    public static Set<Integer> parseInputSets(String line) {
        line = line.replaceAll(" ", "");

        if (!line.matches(SET_REGEX)) {
            throw new InputMismatchException("집합 형식이 잘못되었습니다.");
        }
        StringTokenizer st = new StringTokenizer(line, "\\[\\],");

        Set<Integer> left = new TreeSet<>();
        Set<Integer> right = new TreeSet<>();
        String operator = "";
        while (operator.isEmpty()) {
            String token = st.nextToken();
            if (token.matches("\\d+")) {
                left.add(Integer.valueOf(token));
            } else {
                operator = token;
            }
        }
        while (st.hasMoreTokens()) {
            right.add(Integer.valueOf(st.nextToken()));
        }

        return operateSets(operator, left, right);
    }

    public static <T> Set<T> operateSets(String operator, Set<T> left, Set<T> right) {
        switch (operator) {
            case "+":
                left.addAll(right);
                return left;
            case "-":
                left.removeAll(right);
                return left;
            case "*":
                left.retainAll(right);
                return left;
            default:
                throw new IllegalArgumentException("연산자가 잘못 입력되었습니다.");
        }
    }
}