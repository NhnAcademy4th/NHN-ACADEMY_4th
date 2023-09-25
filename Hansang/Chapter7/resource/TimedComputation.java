package com.nhnacademy.Chapter7.resource;

import java.util.Arrays;

public class TimedComputation {

    public static void sortTimer(int[] test) {

        long startTime; // Starting time of program, in nanoseconds.
        long endTime;   // Time when computations are done, in nanoseconds.
        long compTime;  // Run time in nanoseconds.
        double seconds; // Time difference, in seconds.

        startTime = System.nanoTime();
        Arrays.sort(test);

        endTime = System.nanoTime();
        compTime = endTime - startTime;
        seconds = compTime / 1000000000.0;

        System.out.print("\nRun time in nanoseconds was: ");
        System.out.println(compTime);
        System.out.println("(This is probably not perfectly accurate!");
        System.out.print("\nRun time in seconds was:  ");
        System.out.println(seconds);
    } // end main()

    public static void sortTimer(String[] test) {

        long startTime; // Starting time of program, in nanoseconds.
        long endTime;   // Time when computations are done, in nanoseconds.
        long compTime;  // Run time in nanoseconds.
        double seconds; // Time difference, in seconds.

        startTime = System.nanoTime();
        Arrays.sort(test);

        endTime = System.nanoTime();
        compTime = endTime - startTime;
        seconds = compTime / 1000000000.0;

        System.out.print("\nRun time in nanoseconds was: ");
        System.out.println(compTime);
        System.out.println("(This is probably not perfectly accurate!");
        System.out.print("\nRun time in seconds was:  ");
        System.out.println(seconds);
    } // end main()

    public static void selectionSortTimer(int[] test) {

        long startTime; // Starting time of program, in nanoseconds.
        long endTime;   // Time when computations are done, in nanoseconds.
        long compTime;  // Run time in nanoseconds.
        double seconds; // Time difference, in seconds.

        startTime = System.nanoTime();
        selectionSort(test);

        endTime = System.nanoTime();
        compTime = endTime - startTime;
        seconds = compTime / 1000000000.0;

        System.out.print("\nRun time in nanoseconds was: ");
        System.out.println(compTime);
        System.out.println("(This is probably not perfectly accurate!");
        System.out.print("\nRun time in seconds was:  ");
        System.out.println(seconds);

    }

    public static void selectionSortTimer(String[] test) {

        long startTime; // Starting time of program, in nanoseconds.
        long endTime;   // Time when computations are done, in nanoseconds.
        long compTime;  // Run time in nanoseconds.
        double seconds; // Time difference, in seconds.

        startTime = System.nanoTime();
        selectionSort(test);

        endTime = System.nanoTime();
        compTime = endTime - startTime;
        seconds = compTime / 1000000000.0;

        System.out.print("\nRun time in nanoseconds was: ");
        System.out.println(compTime);
        System.out.println("(This is probably not perfectly accurate!");
        System.out.print("\nRun time in seconds was:  ");
        System.out.println(seconds);

    }

    public static void selectionSort(int[] A) {

        for (int lastPlace = A.length-1; lastPlace > 0; lastPlace--) {

            int maxLoc = 0;

            for (int j = 1; j <= lastPlace; j++) {
                if (A[j] > A[maxLoc]) {

                    maxLoc = j;
                }
            }

            int temp = A[maxLoc];
            A[maxLoc] = A[lastPlace];
            A[lastPlace] = temp;

        }

    }

    public static void selectionSort(String[] A) {
        int index;
        int maxLength;

        for (int lastPlace = (A.length-1); lastPlace > 0; lastPlace--) {

            int maxLoc = 0;
            for (int j = 1; j <= lastPlace; j++) {

                maxLength = Math.min(A[j].length(), A[maxLoc].length());
                maxLoc = CompareString(0, maxLength, A, maxLoc, j);
            }
            String temp = A[maxLoc];
            A[maxLoc] = A[lastPlace];
            A[lastPlace] = temp;
        }
    }

    public static int CompareString(int index, int maxLength, String[] A, int maxLoc, int j){
        while(index < maxLength) {
            if ((A[j].charAt(index) > A[maxLoc].charAt(index))) {
                maxLoc = j;
                break;
            } else if((A[j].charAt(index) == A[maxLoc].charAt(index))) {
                index++;
                continue;
            }
            break;
        }
        return maxLoc;
    }
}
