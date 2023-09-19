package com.exercise.ch04;

public class ex04_7 {


    public static void main(String[] args) {
        makeColorMosaic();
    }

    public static void makeColorMosaic() {
        int row = 40;
        int column = 40;
        Mosaic.open(row, column, 10, 10);
        Mosaic.setUse3DEffect(false);

        fillWithRandomColors(row, column);

        while (true) {
            int currentRow = (int) (row * Math.random());
            int currentColumn = (int) (column * Math.random());
            changeToCopyColor(row, column, currentRow, currentColumn);
            Mosaic.delay(1);
        }
    }

    static void fillWithRandomColors(int row, int column) {
        for (int rowNum = 0; rowNum < row; rowNum++) {
            for (int colNum = 0; colNum < column; colNum++) {
                changeToRandomColor(rowNum, colNum);
            }
        }
    }

    static void changeToRandomColor(int rowNum, int colNum) {
        int red = (int) (256 * Math.random());
        int green = (int) (256 * Math.random());
        int blue = (int) (256 * Math.random());
        Mosaic.setColor(rowNum, colNum, red, green, blue);
    }

    static void changeToCopyColor(int row, int column, int currentRow, int currentColumn) {
        int red = Mosaic.getRed(currentRow, currentColumn);
        int green = Mosaic.getGreen(currentRow, currentColumn);
        int blue = Mosaic.getBlue(currentRow, currentColumn);

        int directionNum = (int) (4 * Math.random());
        switch (directionNum) {
            case 0:
                currentRow--;
                if (currentRow < 0) {
                    currentRow = row - 1;
                }
                break;
            case 1:
                currentColumn++;
                if (currentColumn >= column) {
                    currentColumn = 0;
                }
                break;
            case 2:
                currentRow++;
                if (currentRow >= row) {
                    currentRow = 0;
                }
                break;
            case 3:
                currentColumn--;
                if (currentColumn < 0) {
                    currentColumn = column - 1;
                }
        }

        Mosaic.setColor(currentRow, currentColumn, red, green, blue);
    }
}
