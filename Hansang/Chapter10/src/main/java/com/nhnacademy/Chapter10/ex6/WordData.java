package com.nhnacademy.Chapter10.ex6;

public class WordData {
    String word;
    int lineNumber;

    public WordData(String word, int lineNumber) {
        this.word = word;
        this.lineNumber = lineNumber;
    }

    @Override
    public String toString() {
        return "WordData{" +
                "word='" + word + '\'' +
                ", lineNumber=" + lineNumber +
                '}';
    }
}
