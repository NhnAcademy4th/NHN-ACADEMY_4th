package ch05.resource;

import java.util.Scanner;
import java.util.regex.Pattern;

public class MultifleQuestion {
    Scanner sc = new Scanner(System.in);
    int quizSize = 10;
    private AdditionQuestion[] questionInstances;
    private int[] userAnswer;
    public MultifleQuestion(){
        this.questionInstances = new AdditionQuestion[quizSize];
        this.userAnswer = new int[questionInstances.length];

        for (int i = 0; i < quizSize; i++) {
            questionInstances[i] = new AdditionQuestion(); // AdditionQuestion 객체 초기화
        }
    }

    public MultifleQuestion(int quizSize){
        this.questionInstances = new AdditionQuestion[quizSize];
        this.userAnswer = new int[questionInstances.length];

        for (int i = 0; i < quizSize; i++) {
            questionInstances[i] = new AdditionQuestion(); // AdditionQuestion 객체 초기화
        }
    }

    public void askQuestion(){

        System.out.println("Welcome to ther addtion quiz!");

        for (int i = 0; i < questionInstances.length; i++) {
            System.out.print("Question "+(i+1)+":   "+questionInstances[i].getQuestion());
            userAnswer[i] = inputAnswer();
        }

        sc.close();

        showResult(checkCorrectAnswer());
    }
    private int inputAnswer(){
        String pattern = "^\\d*$";
        String result;

        while(true){
            result = sc.next();
            if(Pattern.matches(pattern,result)){
                return Integer.parseInt(result);
            }else{
                System.out.println("정수형만 입력 가능합니다.");
            }
        }

    }

    private double checkCorrectAnswer(){
        System.out.println("\nHere are the correct answers:");

        double correctCount = 0;

        for (int i = 0; i < userAnswer.length; i++) {
            System.out.print("\tQuestion "+(i+1)+":   "+questionInstances[i].getCorrectAnswer());

            if(questionInstances[i].getCorrectAnswer() == userAnswer[i]){
                System.out.print("   You were CORRECT.\n");
                correctCount++;
            }else{
                System.out.print("   You said " + userAnswer[i] + ", which is INCORRECT\n");
            }
        }
        return correctCount;
    }

    private void showResult(double correctCount){
        System.out.printf("You got %1.0f questions correct\n",correctCount);
        System.out.printf("Your grade on the quiz is %1.0f", correctCount / quizSize * 100);
    }
}
