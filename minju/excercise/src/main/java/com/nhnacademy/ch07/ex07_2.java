package com.nhnacademy.ch07;

public class ex07_2 {
    public static int[][] transposeArray(int[][] array) {
        int[][] transArray = new int[array[0].length][array.length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                transArray[j][i] = array[i][j];
            }
        }
        return transArray;
    }

    public static void print2DArray(int[][] array) {
        for (int[] numbers : array) {
            for (int number : numbers) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        testTransArray();
    }

    private static void testTransArray() {
        int[][] testArray = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        print2DArray(testArray);
        print2DArray(transposeArray(testArray));
    }
}
