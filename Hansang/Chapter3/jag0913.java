package Chapter3;

public class jag0913 {

    public static int gcd(int number1, int number2){
        int temp = 0;
        while(number1%number2 != 0) {
            temp = number1 % number2;
            number1 = number2;
            number2 = temp;
        }

        return number2;
    }

    public static int recursiveGcd(int number1, int number2){
        if(number2 == 0){
            return number1;
        }

        return recursiveGcd(number2, number1% number2);
    }

    public static boolean test(int number1, int number2, int testCasesResult){
        if(number1 == 0 || number2 == 0){
            if(testCasesResult == 0){
                correct++;
                return true;
            }
        } else if(testCasesResult == (number1*number2)/recursiveGcd(number1, number2)){
            correct++;
            return true;
        }
        return false;
    }

    private static double correct = 0;

    private static final int[][] TEST_CASES = {{0,0},{0,6},{0,0},{1,1},{2,81},{3,7},{19,87},{1,40},{18,12},{41,55}};

    private static final int[] TEST_CASES_RESULTS = {0,0,76,1, 162,21,1653,40,36,2255};


    public static void main(String[] args){

        for (int i = 0; i < TEST_CASES.length; i++) {
            System.out.println("Test Case " + (i + 1) + " = " + test(TEST_CASES[i][0], TEST_CASES[i][1], TEST_CASES_RESULTS[i]));
        }

        System.out.printf("정답률 = %.3f%%", (((correct) / (TEST_CASES.length)) * 100));
    }
}
