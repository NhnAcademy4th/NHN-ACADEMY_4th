package com.exercise.ch04;

public class ex04_6 {

    static int currentRow;
    static int currentColumn;

    public static void main(String[] args) {
        makeGreenMosaic();
    }

    public static void makeGreenMosaic() {
        int row = 80;
        int column = 80;
        Mosaic.open(row, column, 5, 5);
        Mosaic.setUse3DEffect(false);

        currentRow = row / 2;
        currentColumn = column / 2;

        while (true) {
            changeToGreen(currentRow, currentColumn);
            randomMove(row, column);
            Mosaic.delay(1);
        }
    }

    public static void changeToGreen(int rowNum, int columnNum) {
        int green = Mosaic.getGreen(rowNum, columnNum) + 25;
        if (green > 225) {
            green = 225;
        }
        Mosaic.setColor(rowNum, columnNum, 0, green, 0);
    }

    static void randomMove(int row, int column) {
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
    }
}
