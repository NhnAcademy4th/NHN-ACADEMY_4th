package ch07;

import java.util.Arrays;

public class ch7_2 {
    private static int[][] Transpose(int[][] arr){
        int[][] result = new int[arr[0].length][arr.length];

        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0; j < arr.length; j++) {
                result[i][j] = arr[j][i];
            }
        }

        return  result;
    }

    public static void main(String[] args) {
        int[][] array = ch7_2.Transpose(new int[][]{{1,2,3,4},{5,6,7,8}});

        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }
}
