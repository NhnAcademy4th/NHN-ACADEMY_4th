package course2.chapter7.ex7_3;

import java.util.Arrays;

public class Sort {

    public int[] sortByMethod(int[] array) {
        int[] sortedArray = array.clone();
        Arrays.sort(sortedArray);
        return sortedArray;
    }

    public String[] sortByMethod(String[] array) {
        String[] sortedArray = array.clone();
        Arrays.sort(sortedArray);
        return sortedArray;
    }

    public String[] sortBySelection(String[] array) {
        String[] sortedArray = array.clone();
        for (int i = 0; i < sortedArray.length - 1; i++) {
            for (int j = i + 1; j < sortedArray.length; j++) {
                if (sortedArray[i].compareTo(sortedArray[j]) > 0) {
                    String temp = sortedArray[i];
                    sortedArray[i] = sortedArray[j];
                    sortedArray[j] = temp;
                }
            }
        }
        return sortedArray;
    }

    public int[] sortBySelection(int[] array) {
        int[] sortedArray = array.clone();
        for (int i = 0; i < sortedArray.length - 1; i++) {
            for (int j = i + 1; j < sortedArray.length; j++) {
                if (sortedArray[i] > sortedArray[j]) {
                    int temp = sortedArray[i];
                    sortedArray[i] = sortedArray[j];
                    sortedArray[j] = temp;
                }
            }
        }
        return sortedArray;
    }
}
