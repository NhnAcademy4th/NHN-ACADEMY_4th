import java.util.Scanner;

public class ex4_8 {

    private static final int PROBLEM_NUM = 10;

    private static int[] first = new int[PROBLEM_NUM];
    private static int[] second = new int[PROBLEM_NUM];
    private static int[] userAnswer = new int[PROBLEM_NUM];

    public static void makeProblem() {
        for (int i = 0; i < first.length; i++) {
            first[i] = (int) (Math.random() * 100) + 1;
            second[i] = (int) (Math.random() * 100) + 1;
        }
    }

    public static void askProblem() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < first.length; i++) {
            System.out.print(first[i] + " + " + second[i] + " = ");
            userAnswer[i] = scanner.nextInt();
        }
    }

    public static void checkAnswer() {
        int count = 0;
        for (int i = 0; i < userAnswer.length; i++) {
            if (first[i] + second[i] == userAnswer[i])
                count++;
        }
        System.out.println("맞은 개수 : " + count);
    }

    public static void main(String[] args) {
        makeProblem();
        askProblem();
        checkAnswer();
    }
}
