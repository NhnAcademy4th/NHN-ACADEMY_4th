package ex07_3;

public class TimeComparator {
    public static void compareTime() {
        System.out.printf("Arrays.Sort(int[]) time : %.5f%n",
                new Sorting().arraySortTime(randomNumbers(1000)));
        System.out.printf("selectionSort(int[]) time : %.5f%n",
                new Sorting().selectionSortTime(randomNumbers(1000)));

        System.out.printf("Arrays.Sort(String[]) time : %.5f%n",
                new Sorting().arraySortTime(randomStrings(1000)));
        System.out.printf("selectionSort(String[]) time : %.5f",
                new Sorting().selectionSortTime(randomStrings(1000)));

    }

    public static Integer[] randomNumbers(int count) {
        Integer[] array = new Integer[count];
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
