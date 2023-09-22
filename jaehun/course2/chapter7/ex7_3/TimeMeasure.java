package course2.chapter7.ex7_3;

public class TimeMeasure {

    public static double getSortingTimeByMethod(int[] array) {
        long startTime = System.nanoTime();
        Sort.sortByMethod(array);
        long endTime = System.nanoTime();
        double seconds = (endTime - startTime)/1000000000.0;
        return seconds;
    }

    public static double getSortingTimeByMethod(String[] array) {
        long startTime = System.nanoTime();
        Sort.sortByMethod(array);
        long endTime = System.nanoTime();
        double seconds = (endTime - startTime)/1000000000.0;
        return seconds;
    }

    public static double getSortingTimeBySelection(int[] array) {
        long startTime = System.nanoTime();
        Sort.sortBySelection(array);
        long endTime = System.nanoTime();
        double seconds = (endTime - startTime)/1000000000.0;
        return seconds;
    }

    public static double getSortingTimeBySelection(String[] array) {
        long startTime = System.nanoTime();
        Sort.sortBySelection(array);
        long endTime = System.nanoTime();
        double seconds = (endTime - startTime)/1000000000.0;
        return seconds;
    }
}
