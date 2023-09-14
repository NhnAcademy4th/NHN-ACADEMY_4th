package ch02;

import java.util.Scanner;

public class ex2_5 {
    public static final int GROSS = 144;
    public static final int DOZEN = 12;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input your eggs : ");

        int eggs = sc.nextInt();

        System.out.println("Your number of eggs is " + eggs / GROSS + " gross, " + (eggs % GROSS) / DOZEN + " dozen, and "
                + (eggs % 144) % 12);

        sc.close();
    }
}
