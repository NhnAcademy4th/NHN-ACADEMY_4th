package ex08_3;

import java.util.Scanner;

public class ex08_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String answer = "-";
        while (true) {
            try {
                System.out.print("Enter the number : ");
                answer = scanner.nextLine();
                if (answer.isEmpty())
                    break;
                if (answer.matches("\\d+")) {
                    System.out.println(new RomanNumeral(Integer.parseInt(answer)).getRomanNumber());
                } else {
                    System.out.println(new RomanNumeral(answer).getArabicNumber());
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
