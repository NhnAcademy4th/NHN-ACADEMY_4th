package ex07_3;

import java.util.Arrays;

//generic 사용하지 않고 overloading만 사용한 class
public class ex07_3 {

    public static void main(String[] args) {
        compareSortTime();
    }

    public static void compareSortTime() {
        System.out.printf("Arrays.Sort(int[]) time : %.5f%n",
                arraySortTime(randomNumbers(1000)));
        System.out.printf("selectionSort(int[]) time : %.5f%n",
                selectionSortTime(randomNumbers(1000)));

        System.out.printf("Arrays.Sort(String[]) time : %.5f%n",
                arraySortTime(randomStrings(1000)));
        System.out.printf("selectionSort(int[]) time : %.5f",
                selectionSortTime(randomStrings(1000)));

    }

    public static double arraySortTime(int[] array) {
        long startTime = System.nanoTime();
        Arrays.sort(array);
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static double arraySortTime(String[] array) {
        long startTime = System.nanoTime();
        Arrays.sort(array);
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static double selectionSortTime(int[] array) {
        long startTime = System.nanoTime();
        selectionSort(array);
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static double selectionSortTime(String[] array) {
        long startTime = System.nanoTime();
        selectionSort(array);
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void selectionSort(int[] array) {
        int minIndex = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            int tmp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = tmp;
        }
    }

    public static void selectionSort(String[] array) {
        int minIndex = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[minIndex].compareTo(array[j]) > 0) {
                    minIndex = j;
                }
            }
            String tmp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = tmp;
        }
    }

    public static int[] randomNumbers(int count) {
        int[] array = new int[count];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * count) + 1;
        }
        return array;
    }

    public static String[] randomStrings(int count) {
        String[] array = new String[count];
        for (int i = 0; i < count; i++) {
            array[i] = randomString();
        }
        return array;
    }

    public static String randomString() {
        String string = "";
        for (int i = 0; i < 5; i++) {
            string += (char) ('A' + (int) (Math.random() * 26));
        }
        return string;
    }

}
