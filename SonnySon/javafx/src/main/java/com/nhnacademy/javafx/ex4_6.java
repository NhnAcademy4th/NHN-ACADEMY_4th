package com.nhnacademy.javafx;
/**
 * This program opens a window full of randomly colored squares.  A "disturbance"
 * moves randomly around in the window, randomly changing the color of each
 * square that it visits.  The program runs until the user closes the window.
 */
public class ex4_6 {

    final static int ROWS = 80;        // Number of rows in mosaic.
    final static int COLUMNS = 80;     // Number of columns in mosaic.
    final static int SQUARE_SIZE = 5; // Size of each square in mosaic.

    static int currentRow;    // Row currently containing the disturbance.
    static int currentColumn; // Column currently containing disturbance.

    static int[][] green = new int[80][80];

    /**
     * The main program creates the window, fills it with random colors,
     * and then moves the disturbances in a random walk around the window
     * as long as the window is open.
     */
    public static void main(String[] args) {
        Mosaic.setUse3DEffect(false);
        Mosaic.open( ROWS, COLUMNS, SQUARE_SIZE, SQUARE_SIZE );
        fillWithBlackColors();
        currentRow = ROWS / 2;   // start at center of window
        currentColumn = COLUMNS / 2;
        while (true) {
            changeToGreenColor(currentRow, currentColumn);
            randomMove();
            Mosaic.delay(5);
        }
    }  // end main


    static void fillWithBlackColors() {
        for (int row=0; row < ROWS; row++) {
            for (int column=0; column < COLUMNS; column++) {
                int red = 0;   // Choose random levels in range
                int green = 0; //     0 to 255 for red, green,
                int blue = 0;  //     and blue color components.
                Mosaic.setColor(row,column,red,green,blue);
            }
        }
    }  // end fillWithRandomColors

    /**
     * Changes one square to a new randomly selected color.
     * Precondition:   The specified rowNum and colNum are in the valid range
     *                 of row and column numbers.
     * Postcondition:  The square in the specified row and column has
     *                 been set to a random color.
     * @param rowNum the row number of the square, counting rows down
     *      from 0 at the top
     * @param colNum the column number of the square, counting columns over
     *      from 0 at the left
     */
    static void changeToGreenColor(int rowNum, int colNum) {
        int gColor = (green[rowNum][colNum] += 25);  //     0 to 255 for red, green,
        if(gColor < 255)
            Mosaic.setColor(rowNum,colNum,0,gColor + 25,0);
    }  // end changeToRandomColor

    /**
     * Move the disturbance.
     * Precondition:   The global variables currentRow and currentColumn
     *                 are within the legal range of row and column numbers.
     * Postcondition:  currentRow or currentColumn is changed to one of the
     *                 neighboring positions in the grid -- up, down, left, or
     *                 right from the current position.  If this moves the
     *                 position outside of the grid, then it is moved to the
     *                 opposite edge of the grid.
     */
    static void randomMove() {
        int directionNum; // Randomly set to 0, 1, 2, or 3 to choose direction.
        directionNum = (int)(4*Math.random());
        switch (directionNum) {
            case 0 -> {  // move up
                currentRow--;
                if (currentRow < 0)
                    currentRow = ROWS - 1;
            }
            case 1 -> {  // move right
                currentColumn++;
                if (currentColumn >= COLUMNS)
                    currentColumn = 0;
            }
            case 2 -> {  // move down
                currentRow ++;
                if (currentRow >= ROWS)
                    currentRow = 0;
            }
            case 3 -> {  // move left
                currentColumn--;
                if (currentColumn < 0)
                    currentColumn = COLUMNS - 1;
            }
        }
    }  // end randomMove

} // end class RandomMosaicWalk2} // end class RandomMosaicWalk