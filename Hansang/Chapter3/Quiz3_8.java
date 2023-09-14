package Chapter3;

import java.util.Scanner;

public class Quiz3_8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        if (number == 0){
            throw new IllegalArgumentException("number must bigger than zero!");
        }
        if (number % 2 == 0) {
            System.out.println(number + " is even number");
        } else if (number % 2 != 0) {
            System.out.println(number + " is odd number");
        }

        sc.close();
    }
}
