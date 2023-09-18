package course2.chapter7.ex7_2;

public class ArrayGenerator {
    private int[][] array;
    private int column;
    private int row;

    public ArrayGenerator(int column, int row) {
        this.column = column;
        this.row = row;
        array = new int[column][row];
    }

    public void setRandomArray(int maxElement) {
        for (int c = 0; c < this.column; c++) {
            for (int r = 0; r < this.row; r++) {
                array[c][r] = (int) (Math.random() * maxElement) + 1;
            }
        }
    }

    public int[][] convertXY(int[][] array) {
        int column = array.length;
        int row = array[0].length;
        int[][] convertedArray = new int[column][row];
        for (int c = 0; c < column; c++) {
            for (int r = 0; r < row; r++) {
                convertedArray[r][c] = array[c][r];
            }
        }
        return convertedArray;
    }

    public int[][] get() {
        return this.array;
    }

}
