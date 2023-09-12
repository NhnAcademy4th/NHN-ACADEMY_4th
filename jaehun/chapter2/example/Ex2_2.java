package chapter2.example;

public class Ex2_2 {
    public static void main(String[] args) {
        int sum = 0;
        int firstDice = (int) (Math.random() * 6) + 1;
        System.out.printf("The first die comes up %d\n", firstDice);
        int secondDice = (int) (Math.random() * 6) + 1;
        System.out.printf("The second die comes up %d\n", secondDice);
        sum = firstDice + secondDice;
        System.out.printf("Your total roll is %d\n", sum);
    }
}
