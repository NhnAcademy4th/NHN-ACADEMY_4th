import java.util.Scanner;

public class ex2_3_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        name = name.toUpperCase();
        System.out.println("Hello, " + name + ", nice to meet you!");
    }
}
