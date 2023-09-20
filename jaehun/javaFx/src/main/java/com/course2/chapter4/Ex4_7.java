package com.course2.chapter4;

public class Ex4_7 {

    final static int ROWS = 40;
    final static int COLUMNS = 40;
    final static int SQUARE_SIZE = 10;

    public static void main(String[] args) {
        Mosaic.setUse3DEffect(false);
        Mosaic.open(ROWS, COLUMNS, SQUARE_SIZE, SQUARE_SIZE);
        fillWithRandomColors();
        while (true) {
            int randomRow = (int) (ROWS * Math.random());
            int randomColumn = (int) (ROWS * Math.random());
            convertRandomNeighbor(randomRow, randomColumn);
            Mosaic.delay(1);
        }
    }

    static void fillWithRandomColors() {
        for (int row = 0; row < ROWS; row++) {
            for (int column = 0; column < COLUMNS; column++) {
                int red = (int) (256 * Math.random());
                int green = (int) (256 * Math.random());
                int blue = (int) (256 * Math.random());
                Mosaic.setColor(row, column, red, green, blue);
            }
        }
    }

    static void convertRandomNeighbor(int row, int col) {
        int red = Mosaic.getRed(row,col);
        int green = Mosaic.getGreen(row,col);
        int blue = Mosaic.getBlue(row,col);
        int directionNum = (int)(4*Math.random());
        switch (directionNum) {
            case 0:
                row--;
                if (row < 0) {
                    row = ROWS - 1;
                }
                break;
            case 1:
                col++;
                if (col >= COLUMNS) {
                    col = 0;
                }
                break;
            case 2:
                row++;
                if (row >= ROWS) {
                    row = 0;
                }
                break;
            case 3:
                col--;
                if (col < 0) {
                    col = COLUMNS - 1;
                }
        }
        Mosaic.setColor(row,col,red,green,blue);
    }
}