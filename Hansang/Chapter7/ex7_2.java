package com.nhnacademy.Chapter7;

import static com.nhnacademy.Chapter7.ex7_1.randomInt;
import static com.nhnacademy.Chapter7.resource.Inputshell.*;

public class ex7_2 {
    private static int[][] arrayAdder(int[][] arr, int MAX){
        for(int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[0].length; j++){
                arr[i][j] = randomInt(MAX);
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        return arr;
    }

    private static int[][] arrayFliper(int[][] arr){
        int[][] transpose = new int[arr[0].length][arr.length];
        for (int i = 0; i < transpose.length; i++){
            for(int j = 0; j < transpose[0].length; j++){
                transpose[i][j] = arr[j][i];
                System.out.print(transpose[i][j] + " ");
            }
            System.out.println();
        }
        return transpose;
    }

    private static void codeActivater(){
        int column = setIntValue("Enter column >>");
        int row = setIntValue("Enter row >>");
        int MAX = setIntValue("Enter Max >>");

        int[][] arr = new int[column][row];

        arrayAdder(arr, MAX);
        System.out.println("----------------------------------");
        arrayFliper(arr);

    }

    public static void main(String[] args) {
        codeActivater();
    }
}
