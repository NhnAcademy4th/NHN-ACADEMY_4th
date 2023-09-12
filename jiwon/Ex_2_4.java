import java.util.Scanner;

public class Ex_2_4 {
    public static void main(String[] args) {
        int quarters;
        int dimes;
        int nicks;
        int pennies;

        Scanner scn = new Scanner(System.in);

        System.out.print("쿼터 수: ");
        quarters = scn.nextInt();

        System.out.print("다임 수: ");
        dimes = scn.nextInt();

        System.out.print("니켈 수: ");
        nicks = scn.nextInt();

        System.out.print("페니 수: ");
        pennies = scn.nextInt();

        int totalCents;
        totalCents = 25 * quarters + 10 * dimes + 5 * nicks + pennies;

        double dollar;
        dollar = totalCents / 100.0;

        System.out.println("동전 수: " + totalCents);
        System.out.println("달러: " + dollar);

        scn.close();
    }
}
