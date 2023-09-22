import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ex07_5 {
    public static void main(String[] args) {
        numberInputShell();
    }

    public static void numberInputShell() {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int number;
        int count = 0;
        while (true) {
            System.out.print("정수를 입력해주세요 : ");
            try {
                number = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("정수가 아닙니다. 다시 입력해주세요.");
                continue;
            }
            if (number == 0 || count == 100)
                break;
            list.add(number);
            count++;
        }
        scanner.close();
        sort(list);
        System.out.println(list.toString());
    }

    private static void sort(ArrayList<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - (i + 1); j++) {
                if (list.get(j) > list.get(j + 1)) {
                    swap(list, j, j + 1);
                }
            }
        }
    }

    private static void swap(ArrayList<Integer> list, int left, int right) {
        int tmp = list.get(left);
        list.set(left, list.get(right));
        list.set(right, tmp);
    }
}
