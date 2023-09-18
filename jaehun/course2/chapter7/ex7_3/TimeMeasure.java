package course2.chapter7.ex7_3;

public class TimeMeasure {
    Sort sort = new Sort();

    public double getSortingTimeByMethod(int[] array) {
        long startTime = System.nanoTime();
        sort.sortByMethod(array);
        long endTime = System.nanoTime();
        double seconds = (endTime - startTime)/1000000000.0;
        return seconds;
    }

    public double getSortingTimeByMethod(String[] array) {
        long startTime = System.nanoTime();
        sort.sortByMethod(array);
        long endTime = System.nanoTime();
        double seconds = (endTime - startTime)/1000000000.0;
        return seconds;
    }

    public double getSortingTimeBySelection(int[] array) {
        long startTime = System.nanoTime();
        sort.sortBySelection(array);
        long endTime = System.nanoTime();
        double seconds = (endTime - startTime)/1000000000.0;
        return seconds;
    }

    public double getSortingTimeBySelection(String[] array) {
        long startTime = System.nanoTime();
        sort.sortBySelection(array);
        long endTime = System.nanoTime();
        double seconds = (endTime - startTime)/1000000000.0;
        return seconds;
    }
}
