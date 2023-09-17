package ex5_7;

import java.util.Scanner;

public class QuestionShell {

    private QuestionShell() {
    }

    private static IntQuestion[] questions = new IntQuestion[11];
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

        int questionNumber = questions.length;

        for (int i = 0; i < 5; i++) {
            questions[i] = new AdditionQuestion();
        }
        for (int i = 5; i < questionNumber - 1; i++) {
            questions[i] = new SubQuestion();
        }
        questions[questionNumber - 1] = new IntQuestion() {
            public String getQuestion() {
                return "What is the answer to the ultimate question " +
                        " of life, the universe, and everything?";
            }

            public int getCorrectAnswer() {
                return 42;
            }
        };
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
