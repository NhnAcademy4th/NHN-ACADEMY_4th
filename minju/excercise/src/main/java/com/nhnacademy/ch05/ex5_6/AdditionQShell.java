package com.nhnacademy.ch05.ex5_6;

import java.util.Scanner;

public class AdditionQShell {

    private static AdditionQuestion[] questions = new AdditionQuestion[10];
    private static int[] answers = new int[questions.length];

    public static void askQuestion() {

        setQuestion();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the addition quiz !\n");

        for (int i = 0; i < questions.length; i++) {
            String question = questions[i].getQuestion();
            System.out.print("Question " + (i + 1) + " : " + question);
            answers[i] = scanner.nextInt();
        }

        scanner.close();

        grading();

    }

    private static void setQuestion() {
        for (int i = 0; i < questions.length; i++) {
            questions[i] = new AdditionQuestion();
        }
    }

    private static void grading() {
        int count = 0;
        for (int i = 0; i < answers.length; i++) {
            String question = questions[i].getQuestion();
            int correctAnswer = questions[i].getCorrectAnswer();

            System.out.print("Question " + (i + 1) + " : " + question + correctAnswer);

            boolean isCorrect = answers[i] == questions[i].getCorrectAnswer();
            if (isCorrect) {
                count++;
                System.out.println(".    You were CORRECT.");
            } else {
                System.out.println(".    You said " + answers[i] + ", which is INCORRECT.");
            }
        }
        System.out.println("You got " + count + "questions correct.");
        System.out.println("Your grade on the quiz is " + (10 * count) + ".");
    }

}
