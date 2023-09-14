import java.util.Scanner;

public class ex2_5_1 {

    private static final int GROSS_OF_EGGS = 144;
    private static final int DOZEN_OF_EGGS = 12;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("how many eggs : ");
        int eggs = scanner.nextInt();

        int gross = eggs / GROSS_OF_EGGS;
        eggs = eggs % GROSS_OF_EGGS;

        int dozen = eggs / DOZEN_OF_EGGS;
        eggs = eggs % DOZEN_OF_EGGS;

        System.out.println("Your number of eggs is " + gross + " gross, " + dozen + " dozen, and " + eggs);
    }
}
