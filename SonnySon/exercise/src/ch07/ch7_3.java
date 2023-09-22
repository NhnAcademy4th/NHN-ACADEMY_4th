package ch07;

import java.util.Arrays;

public class ch7_3 {

    private static double[] createRandomIntArrays(int length, int maxNum) {
        double[] resultArray = new double[length];
        for (int i = 0; i < length; i++) {
            resultArray[i] = (Math.random() * maxNum);
        }
        return resultArray;
    }

    private static String[] createRandomStringArrays(int length) {
        String[] resultArray = new String[length];
        for (int i = 0; i < length; i++) {
            resultArray[i] = createRandomWord();
        }
        return resultArray;
    }

    private static String createRandomWord() {
        StringBuilder st = new StringBuilder();
        for (int j = 0; j < (Math.random() * 7) + 1; j++) {
            st.append((char) ((int) (Math.random() * 26 + 97)));
        }
        return st.toString();
    }

    private static void sortByArrays(double[] array) {
        double[] copyArray = Arrays.copyOf(array, array.length);

        long startTime = System.nanoTime();

        Arrays.sort(copyArray);

        double time = (System.nanoTime() - startTime) / 1000000000.0;

//        System.out.println(Arrays.toString(copyArray));
        System.out.printf("SortByArrays : %1.5f", time);
    }

    private static void sortByArrays(String[] array) {
        String[] copyArray = Arrays.copyOf(array, array.length);

        long startTime = System.nanoTime();

        Arrays.sort(copyArray);

        double time = (System.nanoTime() - startTime) / 1000000000.0;

//        System.out.println(Arrays.toString(copyArray));
        System.out.printf("SortByArrays : %1.5f", time);
    }

    private static void sortBySelectionSort(double[] array) {
        double[] copyArray = Arrays.copyOf(array, array.length);

        long startTime = System.nanoTime();

        selectionSort(copyArray);

        double time = (System.nanoTime() - startTime) / 1000000000.0;

//        System.out.println(Arrays.toString(array));
        System.out.printf("SortBySelectionSort : %1.5f", time);
    }

    private static void sortBySelectionSort(String[] array) {
        String[] copyArray = Arrays.copyOf(array, array.length);

        long startTime = System.nanoTime();

        selectionSort(copyArray);

        double time = (System.nanoTime() - startTime) / 1000000000.0;

//        System.out.println(Arrays.toString(array));
        System.out.printf("SortBySelectionSort : %1.5f", time);
    }

    private static double[] selectionSort(double[] array) {
        for (int lastPlace = array.length - 1; lastPlace > 0; lastPlace--) {

            int maxLoc = 0;

            for (int i = 1; i <= lastPlace; i++) {
                if (array[i] > array[maxLoc]) {
                    maxLoc = i;
                }
            }

            double temp = array[lastPlace];
            array[lastPlace] = array[maxLoc];
            array[maxLoc] = temp;

        }
        return array;
    }

    private static String[] selectionSort(String[] array) {
        for (int lastPlace = array.length - 1; lastPlace > 0; lastPlace--) {

            int maxLoc = 0;

            for (int i = 1; i <= lastPlace; i++) {
                if (!isFirstWord(array[i], array[maxLoc]))
                    maxLoc = i;
            }
            String temp = array[lastPlace];
            array[lastPlace] = array[maxLoc];
            array[maxLoc] = temp;
        }
        return array;
    }
    private static boolean isFirstWord(String word1, String word2) {
        char[] charArray1 = word1.toCharArray();
        char[] charArray2 = word2.toCharArray();

        int shortWordLength = Math.min(charArray1.length, charArray2.length);

        for(int i = 0; i < shortWordLength; i++) {
            if(charArray1[i] != charArray2[i]){
                return charArray1[i] < charArray2[i];
            }
        }
        return shortWordLength == charArray1.length;
    }



    public static void main(String[] args) {
        double[] testArrays = ch7_3.createRandomIntArrays(10000,1000);
        sortByArrays(testArrays);
        System.out.println();
        sortBySelectionSort(testArrays);

        System.out.println();

        String[] stringTestArrays = ch7_3.createRandomStringArrays(10000);
        sortByArrays(stringTestArrays);
        System.out.println();
        System.out.println(Arrays.toString(selectionSort(stringTestArrays)));
    }
}


//    private static boolean isFirstWord(String word1, String word2) {
//        char[] charArray1 = word1.toCharArray();
//        char[] charArray2 = word2.toCharArray();
//
//        int shortWordLength = Math.min(charArray1.length, charArray2.length);
//
//        for (int i = 0; i < shortWordLength; i++) {
//            if(charArray1[i]>charArray2[i]){
//                return false;
//            }else if(charArray1[i]<charArray2[i]){
//                return true;
//            }
//        }
//        return shortWordLength == charArray1.length;
//    }
