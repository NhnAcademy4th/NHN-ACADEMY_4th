package ch03;

import java.util.Scanner;

public class ex3_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Widget Amount: ");
        int widget = sc.nextInt();
        System.out.print("Widget Price: ");
        int price = sc.nextInt();

        System.out.printf("%1.2f", (double) widget * price);
    }
}
