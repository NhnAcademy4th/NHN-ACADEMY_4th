package course2.chapter7.ex7_5;

public class Sort {
    public double[] sortByBubble(double[] array) {
        double[] sortedArray = array.clone();
        for (int i = sortedArray.length; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (sortedArray[j] > sortedArray[j + 1]) {
                    double temp = sortedArray[j];
                    sortedArray[j] = sortedArray[j + 1];
                    sortedArray[j + 1] = temp;
                }
            }
        }
        return sortedArray;
    }
}
