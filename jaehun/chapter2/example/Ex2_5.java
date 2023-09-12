package chapter2.example;

import java.util.Scanner;

public class Ex2_5 {
    public static void main(String[] args) {
        System.out.print("달갈 총 개수를 입력:");
        Scanner sc = new Scanner(System.in);
        Integer number = Integer.parseInt(sc.nextLine());
        int gross = number / 144;
        number %= 144;
        int dozen = number / 12;
        number %= 12;
        int leftEggs = number;
        System.out.println("계란 수는 총" + gross + "개, 다스 " + dozen + "개, " + leftEggs + "개입니다.");
    }
}
