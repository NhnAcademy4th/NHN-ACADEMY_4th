package ch04;

import java.util.Scanner;

public class ex4_8 {
    private static int[][] QUIZ = {
            {3,6},
            {1,2},
            {3,4},
            {8,3},
            {5,6},
            {3,2},
            {2,6},
            {4,7},
            {6,7},
            {7,2}
    };

    private static int[] QUIZ_ANSWER = {
            9,3,7,11,11,5,8,11,13,9
    };

    private static int[] ANSWER = new int[QUIZ.length];

    private static String createQuiz(int num1, int num2){
        return num1 +" + "+ num2 +" ? ";
    }

    private static void adminQuiz(){
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i< QUIZ.length;i++){
            System.out.print(createQuiz(QUIZ[i][0],QUIZ[i][1]));
            try{
                ANSWER[i] = sc.nextInt();
            }catch(IllegalArgumentException e){
                System.out.println("숫자여야함");
            }
        }
        isCorrect();
    }
    private static void isCorrect(){
        int count = 0;

        for(int i = 0;i<QUIZ.length;i++){
            if(ANSWER[i] == QUIZ_ANSWER[i]){
                count++;
            }
        }
        System.out.println("맞은 개수 " + count);
    }

    public static void main(String[] args) {
        adminQuiz();
    }
}
