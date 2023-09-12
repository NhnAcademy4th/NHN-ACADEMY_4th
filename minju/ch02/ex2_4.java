import java.util.Scanner;

public class ex2_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("quaters : ");
        int quarters = scanner.nextInt();

        System.out.print("dimes : ");
        int dimes = scanner.nextInt();

        System.out.print("nickels : ");
        int nickels = scanner.nextInt();

        System.out.print("pennies : ");
        int pennies = scanner.nextInt();

        double dollars = quarters * 0.25 + dimes * 0.1 + nickels * 0.05 + pennies * 0.01;
        System.out.println(dollars);
    }
}
