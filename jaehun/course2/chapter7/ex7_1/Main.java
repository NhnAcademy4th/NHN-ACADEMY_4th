package course2.chapter7.ex7_1;

import java.util.ArrayList;

public class Main {
    private static ArrayListGenerator generator = new ArrayListGenerator();

    public static void main(String[] args) {
        test(3, 10);
        test(10, 10);
        test(11, 10);
        test(-1, 10);
    }

    public static void test(int count, int maxValue) {
        try {
            generator.generate(count, maxValue);
            System.out.println(generator.getArrayList());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
