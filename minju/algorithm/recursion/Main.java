public class Main {

    public static void main(String[] args) {

        for (int i = 0; i < FACTORIAL_TEST_CASES.length; i++) {
            System.out.println("Factorial Test " + (i + 1) + " = "
                    + factorialTest(FACTORIAL_TEST_CASES[i], FACTORIAL_TEST_CASE_RESULTS[i]));
        }
        System.out.printf("정답률 : %.3f%%%n", factorialCorrect / FACTORIAL_TEST_CASES.length * 100.0);

        for (int i = 0; i < FIBONACCI_TEST_CASES.length; i++) {
            System.out.println("Fibonacci Test " + (i + 1) + " = "
                    + fibonacciTest(FIBONACCI_TEST_CASES[i], FIBONACCI_TEST_CASE_RESULTS[i]));
        }
        System.out.printf("정답률 : %.3f%%", fibonacciCorrect / FIBONACCI_TEST_CASES.length * 100.0);

    }

    private static boolean fibonacciTest(int input, int output) {
        if (fibonacci(input) == output) {
            fibonacciCorrect++;
            return true;
        }
        return false;
    }

    private static boolean factorialTest(int input, int output) {

        if (factorial(input) == output) {
            factorialCorrect++;
            return true;
        }
        return false;
    }

    private static double factorialCorrect = 0;
    private static double fibonacciCorrect = 0;

    private static final int[] FACTORIAL_TEST_CASES = {
            0,
            5
    };

    private static final int[] FACTORIAL_TEST_CASE_RESULTS = {
            1,
            120
    };

    private static final int[] FIBONACCI_TEST_CASES = {
            0,
            2,
            10
    };

    private static final int[] FIBONACCI_TEST_CASE_RESULTS = {
            0,
            1,
            55
    };

    public static long factorial(int number) {
        switch (number) {
            case 0:
            case 1:
                return 1;
            default:
                return number * factorial(number - 1);
        }
    }

    public static long fibonacci(int number) {
        switch (number) {
            case 0:
                return 0;
            case 1:
            case 2:
                return 1;
            default:
                return fibonacci(number - 1) + fibonacci(number - 2);
        }
    }
}