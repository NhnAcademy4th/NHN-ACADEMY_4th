/**
 * Main
 */
public class Main {

    private static final int[][] TEST_CASES = {
            { 0, 0 },
            { 1, 1 },
            { 98, 49 },
            { 2, 81 },
            { 3, 7 },
            { 19, 87 },
            { 1, 40 },
            { 9929, 3384 }
    };

    private static final int[] TEST_CASES_RESULTS = {
            0,
            1,
            98,
            162,
            21,
            1653,
            40,
            33599736
    };

    public static void main(String[] args) {

        for (int i = 0; i < TEST_CASES.length; i++) {
            System.out.println("Test case" + (i + 1) + " = " + test(TEST_CASES[i], TEST_CASES_RESULTS[i]));
        }
        System.out.printf("정답률 = %.3f%%", (correct / TEST_CASES.length * 100));

    }

    private static double correct = 0;

    public static boolean test(int[] input, int result) {
        if (solution(input[0], input[1]) == result) {
            correct++;
            return true;
        }
        return false;
    }

    private static int solution(int first, int second) {
        if (first == 0 || second == 0) {
            return 0;
        }
        return (first * second) / gcd(first, second);
    }

    private static int gcd(int first, int second) {
        if (second == 0) {
            return first;
        }
        return gcd(second, first % second);
    }

}