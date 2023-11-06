package com.nhnacademy.ch10.ex10_5;

public class ScoreInfo {
    private final String lastName;
    private final String firstName;
    private final int score;

    public ScoreInfo(String lastName, String firstName, int score) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public String getlastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + score;
    }

}