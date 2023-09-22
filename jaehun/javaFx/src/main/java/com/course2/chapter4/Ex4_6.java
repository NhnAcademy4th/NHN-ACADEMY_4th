package com.course2.chapter4;

import com.course2.chapter4.Mosaic;

public class Ex4_6 {

    final static int ROWS = 80;
    final static int COLUMNS = 80;
    final static int SQUARE_SIZE = 5;

    static int currentRow;
    static int currentColumn;

    public static void main(String[] args) {
        Mosaic.setUse3DEffect(false);
        Mosaic.open( ROWS, COLUMNS, SQUARE_SIZE, SQUARE_SIZE );
        currentRow = ROWS / 2;
        currentColumn = COLUMNS / 2;
        while (true) {
            changeToGreen(currentRow, currentColumn);
            randomMove();
            Mosaic.delay(1);
        }
    }

    static void changeToGreen(int rowNum, int colNum){
        int green = Mosaic.getGreen(rowNum,colNum)+25;
        if(green>255){
            green = 255;
        }
        Mosaic.setColor(rowNum,colNum,0,green,0);
    }

    static void randomMove() {
        int directionNum;
        directionNum = (int)(4*Math.random());
        switch (directionNum) {
            case 0:
                currentRow--;
                if (currentRow < 0)
                    currentRow = ROWS - 1;
                return;
            case 1:
                currentColumn++;
                if (currentColumn >= COLUMNS)
                    currentColumn = 0;
                return;
            case 2 :
                currentRow ++;
                if (currentRow >= ROWS)
                    currentRow = 0;
                return;
            case 3:
                currentColumn--;
                if (currentColumn < 0)
                    currentColumn = COLUMNS - 1;
        }
    }
}