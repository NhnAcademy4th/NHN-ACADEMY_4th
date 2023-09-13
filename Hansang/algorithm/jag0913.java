package com.Chapter2.algorithm;

public class jag0913 {

    public static int gcd(int a, int b){
        int temp = 0;
        while(a%b != 0) {
            temp = a % b;
            a = b;
            b = temp;
        }
        return b;
    }

    public static boolean test(int a, int b, int testCasesResult){
        if(testCasesResult == (a*b)/gcd(a, b)){
            correct++;
            return true;
        }
        return false;
    }

    private static double correct = 0;

    private static final int[][] TEST_CASES = {{1,1},{2,81},{3,7},{19,87},{1,40}};

    private static final int[] TEST_CASES_RESULTS = {1, 162,21,1653,40};


    public static void main(String[] args){

        for (int i = 0; i < TEST_CASES.length; i++) {
            System.out.println("Test Case " + (i + 1) + " = " + test(TEST_CASES[i][0], TEST_CASES[i][1], TEST_CASES_RESULTS[i]));
        }

        System.out.printf("정답률 = %.3f%%", (correct / TEST_CASES.length * 100));
    }
}
