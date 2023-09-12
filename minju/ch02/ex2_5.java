import java.util.Scanner;

public class ex2_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("how many eggs : ");
        int eggs = scanner.nextInt();

        int gross = eggs / 144;
        eggs = eggs % 144;

        int dozen = eggs / 12;
        eggs = eggs % 12;

        System.out.println("Your number of eggs is " + gross + " gross, " + dozen + " dozen, and " + eggs);
    }
}
