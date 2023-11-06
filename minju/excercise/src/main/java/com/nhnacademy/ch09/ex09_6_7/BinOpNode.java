package com.nhnacademy.ch09.ex09_6_7;

import java.util.Objects;

public class BinOpNode extends ExpNode {
    private char operator;
    protected ExpNode left;
    protected ExpNode right;

    public BinOpNode(char operator, ExpNode left, ExpNode right) {

        if (!isOperator(operator)) {
            throw new IllegalArgumentException("BinOpNode : 잘못된 연산자입니다.");
        }

        if (Objects.isNull(left) || Objects.isNull(right)) {
            throw new IllegalArgumentException("BinOpNode : 값은 비어있을 수 없습니다.");
        }

        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    private boolean isOperator(char operator) {
        switch (operator) {
            case '+':
            case '-':
            case '*':
            case '/':
                return true;
            default:
                return false;
        }
    }

    @Override
    public double value(double xValue) {
        double x = left.value(xValue);
        double y = right.value(xValue);
        switch (operator) {
            case '+':
                return x + y;
            case '-':
                return x - y;
            case '*':
                return x * y;
            case '/':
                return x / y;
            default:
                return Double.NaN;
        }
    }

    @Override
    public void printStackCommands() {
        left.printStackCommands();
        right.printStackCommands();
        System.out.println("Operator " + operator);
    }

    @Override
    public ExpNode derivative() {
        switch (operator) {
            case '+':
            case '-':
                return new BinOpNode(operator, left.derivative(), right.derivative());
            case '*':
                return new BinOpNode('+',
                        new BinOpNode(operator, left, right.derivative()),
                        new BinOpNode(operator, right, left.derivative()));
            case '/':
                return new BinOpNode(operator,
                        new BinOpNode('-',
                                new BinOpNode('*', right, left.derivative()),
                                new BinOpNode('*', left, right.derivative())),
                        new BinOpNode('*', right, right));

            default:
                return null;
        }
    }

    @Override
    void printInfix() {
        System.out.print("(");
        left.printInfix();
        System.out.print(" " + operator + " ");
        right.printInfix();
        System.out.print(")");

    }

}
