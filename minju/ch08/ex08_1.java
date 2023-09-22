import java.util.Scanner;

/**
 * ex08_1
 */
public class ex08_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {

                System.out.print("Enter A : ");
                String inputA = scanner.nextLine().toLowerCase();

                System.out.print("Enter B : ");
                String inputB = scanner.nextLine().toLowerCase();

                System.out.print("Enter C : ");
                String inputC = scanner.nextLine().toLowerCase();

                if (inputA.equals("no") || inputB.equals("no") || inputC.equals("no")) {
                    System.out.println("종료합니다.");
                    break;
                }

                String check = "\\d+(.\\d+)?";
                if (!(inputA.matches(check) && inputB.matches(check) && inputC.matches(check))) {
                    System.out.println("값이 잘못 입력되었습니다. 다시 입력해주세요.");
                    continue;
                }

                double A = Double.parseDouble(inputA);
                double B = Double.parseDouble(inputB);
                double C = Double.parseDouble(inputC);
                System.out.println("result : " + root(A, B, C));

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }

    static public double root(double A, double B, double C)
            throws IllegalArgumentException {
        if (A == 0) {
            throw new IllegalArgumentException("A can't be zero.");
        } else {
            double disc = B * B - 4 * A * C;
            if (disc < 0)
                throw new IllegalArgumentException("Discriminant < zero.");
            return (-B + Math.sqrt(disc)) / (2 * A);
        }
    }
}
