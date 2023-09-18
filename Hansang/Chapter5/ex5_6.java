package com.nhnacademy.Chapter5;

public class ex5_6 {

    private static void additionQuiz(IntQuestion[] quiz, int index) {
        AdditionQuestion aq = new AdditionQuestion();
        quiz[index] = aq;
    }

    private static void subtractionQuiz(IntQuestion[] quiz, int index) {
        SubtractionQuestion sq = new SubtractionQuestion();
        quiz[index] = sq;
    }

    private static void quizEditor(IntQuestion[] quiz, int index) {
        IntQuestion bigQuestion = new IntQuestion() {
            @Override
            public String getQuestion() {
                return "what is the answer of the ultimate question " +
                        " of life, the universe, and everything?";
            }

            @Override
            public int getCorrectAnswer() {
                return 42;
            }
        };
        quiz[index] = bigQuestion;
    }

    private static int getIntValue() {
        int value;
        try {
            value = Integer.parseInt(Inputshell.inputFromshell());
        } catch (Exception e) {
            throw new IllegalArgumentException("not boundary of Integer!");
        }
        return value;
    }

    public static void quizManager() {
        int amount = getIntValue();

        IntQuestion[] quiz = new IntQuestion[amount];
        int[] answer = new int[amount];

        for (int i = 0; i < amount; i++) {
            additionQuiz(quiz, i);
            System.out.print(quiz[i].getQuestion());
            answer[i] = getIntValue();
        }
        answerPrinter(amount, quiz, answer);
    }

    public static void quizMangerVersion2() {
        int amount = getIntValue();
        int halfAmount = amount / 2;

        IntQuestion[] quiz = new IntQuestion[amount + 1];
        int[] answer = new int[amount + 1];


        for (int i = 0; i < halfAmount; i++) {
            additionQuiz(quiz, i);
            System.out.print(quiz[i].getQuestion());
            answer[i] = getIntValue();
        }
        for (int i = halfAmount; i < amount; i++) {
            subtractionQuiz(quiz, i);
            System.out.print(quiz[i].getQuestion());
            answer[i] = getIntValue();
        }

        quizEditor(quiz, amount);
        System.out.println(quiz[amount].getQuestion());
        answer[amount] = getIntValue();

        answerPrinter((amount + 1), quiz, answer);
    }

    private static void answerPrinter(int amount, IntQuestion[] quiz, int[] answer) {
        double totalScore = 0;

        for (int i = 0; i < amount; i++) {
            System.out.println(quiz[i].getQuestion());
            System.out.println("your answer was : " + answer[i]);

            if (checkScore(answer[i], quiz[i].getCorrectAnswer())) {
                System.out.println("your answer is correct!");
                totalScore += (100.0 / amount);
            } else {
                System.out.println("your answer is incorrect!");
                System.out.println("answer is " + quiz[i].getCorrectAnswer());
            }
        }

        System.out.println("totalScore is " + totalScore);
    }

    private static boolean checkScore(int answer, int quizAnswer) {
        return answer == quizAnswer;
    }

    public static void main(String[] args) {
        quizManager();
    }

}
