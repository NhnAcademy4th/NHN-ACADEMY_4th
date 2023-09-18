package com.nhnacademy;

import java.util.Scanner;

public class ex4_8 {

    private static int[][] quizGenerator(int[][] quiz, int index){
        quiz[index][0] = ((int) (Math.random() * 100)) + 1;
        quiz[index][1] = ((int) (Math.random() * 100)) + 1;
        quiz[index][2] = quiz[index][0] + quiz[index][1];
        return quiz;
    }

    private static void quizManager(){
        //문제 수량을 입력받는다
        //입력받은 수량이 int max 값을 예외처리
        //입력받은 수량만큼 어레이를 만들어주고
        int amount;
        try {
            amount = inputFromShell();
        }catch (Exception e){
            throw new IllegalArgumentException("not boundary of Integer!");
        }

        int[][] quiz = new int[amount][3];
        int[] answer = new int[amount];

        for(int i = 0; i < amount; i++){
            quizGenerator(quiz, i);
            System.out.print(quiz[i][0] + " + " + quiz[i][1] + " = " );
            answer[i] = inputFromShell();
        }
        double totalScore = 0;

        for(int i = 0; i < amount; i++){
            System.out.println(quiz[i][0] + " + " + quiz[i][1] + " = " + answer[i] );
            if(checkScore(answer[i], quiz[i][2])){
                System.out.println("your answer is correct!");
                totalScore  += (100.0 / amount);
            } else {
                System.out.println("your answer is incorrect!");
                System.out.println("answer is " + quiz[i][2]);
            }
        }
        System.out.println("totalScore is " + totalScore);
    }

    private static int inputFromShell() {
        Scanner sc = new Scanner(System.in);
        int integerValue = sc.nextInt();
        return integerValue;
    }

    private static boolean checkScore(int answer, int quizAnswer){
        return answer == quizAnswer;
    }

    public static void main(String[] args) {
        quizManager();
    }
}
