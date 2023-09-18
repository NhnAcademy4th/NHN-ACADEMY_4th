package com.nhnacademy.Chapter5;

public class SubtractionQuestion implements IntQuestion {

    private int num1, num2;

    public SubtractionQuestion() {
        boolean isPositive;
        this.num1 = (int) (Math.random() * 50 + 1);

        do {
            isPositive = ((num1 - num2) > 0);
            this.num2 = (int) (Math.random() * 50);
        } while (isPositive);
    }

    @Override
    public String getQuestion() {
        return "What is " + num1 + " - " + num2 + " ? ";
    }

    @Override
    public int getCorrectAnswer() {
        return num1 - num2;
    }
}