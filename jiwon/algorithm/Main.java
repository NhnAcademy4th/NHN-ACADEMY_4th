package Q_0913;

public class Main {

    private static final int[][] TEST_CASES = {
            { 1, 1 },
            { 98, 49 },
            { 2, 81 },
            { 3, 7 },
            { 19, 87 },
            { 1, 40 }
    };

    private static final int[] TEST_CASES_RESULTS = {
            1,
            98,
            162,
            21,
            1653,
            40
    };

    private static double correct = 0.0;

    private static boolean test(int start, int end, int result) {
        if (solution(start, end) == result) {
            correct++;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        for (int i = 0; i < TEST_CASES.length; i++) {
            System.out.println(
                    "TestCase" + (i + 1) + " = " + test(TEST_CASES[i][0], TEST_CASES[i][1], TEST_CASES_RESULTS[i]));
        }
        System.out.printf("정답률 = %.3f%%", (correct / TEST_CASES.length * 100));
    }

    public static int gcd(int first, int second) {
        if (second == 0) {
            return first;
        } else
            return gcd(second, first % second);
    }

    public static int solution(int first, int second) {
        int divisorNum = gcd(first, second);
        return (first * second) / divisorNum;
    }

}