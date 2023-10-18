package com.nhnacademy.Chapter10.ex2;

import java.util.Iterator;
import java.util.TreeSet;

public class SetOperator {

    private TreeSet<Integer> left;
    private TreeSet<Integer> right;
    private char operator;
    private static int index;

    public void showResult() {
        Iterator<Integer> iterator = left.iterator();
        System.out.print("result >>  [");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.print(" ]\n");
    }

    public SetOperator(String input) {
        left = new TreeSet<>();
        right = new TreeSet<>();
        splitWithOperator(input, left);
        extractOperator(input);
        splitWithOperator(input, right);
    }

    public void getResult() {
        switch (operator) {
            case '+':
                left.addAll(right);
                break;
            case '-':
                left.removeAll(right);
                break;
            case '*':
                left.retainAll(right);
                break;
            default:
                throw new IllegalArgumentException("wrong operator!!");
        }
    }

    private void extractOperator(String input) {
        final String OPER_REGULAR = "[-+*]";
        while (true) {
            if (String.valueOf(lookChar(input, index)).matches(OPER_REGULAR)) {
                operator = lookChar(input, index);
                break;
            }
            index++;
        }
    }

    private static void splitWithOperator(String setNumbers, TreeSet<Integer> treeSet) {
        if (setNumbers == null) {
            throw new IllegalArgumentException("Can not split!");
        }
        char ch;
        while (true) {
            StringBuilder sb = new StringBuilder();
            ch = lookChar(setNumbers, index);
            if (Character.isDigit(ch)) {
                while (Character.isDigit(ch)) {
                    sb.append(ch);
                    index++;
                    ch = lookChar(setNumbers, index);
                }
                treeSet.add(Integer.parseInt(sb.toString()));
            }
            if (lookChar(setNumbers, index) == ']') {
                return;
            }
            index++;
        }

    }

    private static char lookChar(String buffer, int bufferIndex) {
        if (buffer == null || bufferIndex > buffer.length()) {
            throw new IllegalArgumentException("Data not exist!");
        } else if (bufferIndex == buffer.length()) {
            return '\n';
        } else if ((buffer.charAt(bufferIndex) == ' ')) {
            index++;
            return lookChar(buffer, index);
        } else {
            return buffer.charAt(bufferIndex);
        }
    }

}
