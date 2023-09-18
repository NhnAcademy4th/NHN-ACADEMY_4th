package course2.chapter7.ex7_2;

public class Main {
    public static void main(String[] args) {
        int column = 4;
        int row = 5;
        ArrayGenerator generator = new ArrayGenerator(column, row);
        System.out.println("2차원 배열을 만듭니다.");
        generator.setRandomArray(10);
        System.out.println("원래 배열");
        int[][] originalArray = generator.get();
        for (int c = 0; c < column; c++) {
            for (int r = 0; r < row; r++) {
                System.out.print(originalArray[c][r] + " ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("행과 열이 바뀐 배열");
        int[][] convertedArray = generator.convertXY(originalArray);
        for (int c = 0; c < column; c++) {
            for (int r = 0; r < row; r++) {
                System.out.print(convertedArray[c][r] + " ");
            }
            System.out.println();
        }
    }
}
