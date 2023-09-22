package com.nhnacademy.Chapter5;

public class AdditionQuestion implements IntQuestion {

    private int num1, num2;

    public AdditionQuestion() {
        this.num1 = (int) (Math.random() * 50 + 1);
        this.num2 = (int) (Math.random() * 50);
    }

    @Override
    public String getQuestion() {
        return "What is " + num1 + " + " + num2 + " ? ";
    }

    @Override
    public int getCorrectAnswer() {
        return num1 + num2;
    }
}

