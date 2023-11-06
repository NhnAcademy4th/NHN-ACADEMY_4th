package com.nhnacademy.ch09.ex09_6_7;

public class VariableNode extends ExpNode {

    @Override
    public double value(double xValue) {
        return xValue;
    }

    @Override
    public void printStackCommands() {
        System.out.println("Push X");
    }

    @Override
    ExpNode derivative() {
        return new ConstNode(1);
    }

    @Override
    void printInfix() {
        System.out.print("x");
    }

}
