package course2.chapter7.ex7_2;

public class Main {
    private static TwoDimensionArray twoDimensionArray = new TwoDimensionArray();

    public static void main(String[] args) {
        test(5, 4);
        test(5, 5);
        test(-1, 0);
        test(3, 3);
    }

    public static void test(int columns, int rows) {
        try {
            twoDimensionArray.setRandomArray(columns, rows);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("original 2차원 배열");
        twoDimensionArray.printArray();

        System.out.println("transpose 2차원 배열");
        twoDimensionArray.transposeArray();
        twoDimensionArray.printArray();
    }
}
