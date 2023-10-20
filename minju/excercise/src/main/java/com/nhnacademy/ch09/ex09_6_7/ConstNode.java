package com.nhnacademy.ch09.ex09_6_7;

public class ConstNode extends ExpNode {

    private double value;

    public ConstNode(double value) {
        this.value = value;
    }

    @Override
    public double value(double xValue) {
        return value;
    }

    @Override
    public void printStackCommands() {
        System.out.println("Push " + value);
    }

    @Override
    ExpNode derivative() {
        return new ConstNode(0);
    }

    @Override
    void printInfix() {
        System.out.print(value);
    }
}
