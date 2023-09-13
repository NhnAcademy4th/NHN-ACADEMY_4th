package algorithm;

public class gcdTest {

    private static int gcd(int number1, int number2) {
        if (number1 % number2 == 0) {
            return number2;
        }

        return gcd(number2, number1 % number2);
    }

    private static int lcm(int number1, int number2) {
        return number1 * number2 / gcd(number1, number2);
    }

    private static double correct = 0;

    private static boolean test(int num1, int num2, int result) {
        System.out.println(lcm(num1, num2));
        if (lcm(num1, num2) == result) {
            correct++;
            return true;
        }
        return false;
    }

    private static final int[][] TEST_CASES = {
            { 1, 1 },
            { 98, 49 },
            { 2, 81 },
            { 3, 7 },
            { 19, 87 },
            { 1, 40 }
    };

    private static final int[] TEST_CASES_RESULTS = {
            1, 98, 162, 21, 1653, 40
    };

    public static void main(String[] args) {
        for (int i = 0; i < TEST_CASES.length; i++) {
            System.out.println(
                    "Test Case " + i + " = " + test(TEST_CASES[i][0], TEST_CASES[i][1], TEST_CASES_RESULTS[i]));
        }

        System.out.printf("정답률 : %f", (correct / TEST_CASES.length * 100));
    }

}
