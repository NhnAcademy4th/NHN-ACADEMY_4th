/**
 * ex4_5
 */
public class ex4_5 {

    private static final ArrayProcessor maxArray = array -> {
        double max = array[0];
        for (double number : array) {
            if (max < number) {
                max = number;
            }
        }
        return max;
    };

    public static ArrayProcessor min = array -> {
        double min = array[0];
        for (double number : array) {
            if (min > number) {
                min = number;
            }
        }
        return min;
    };

    public static ArrayProcessor sum = array -> {
        double sum = 0;
        for (double number : array) {
            sum += number;
        }
        return sum;
    };

    public static ArrayProcessor average = array -> {
        return sum.apply(array) / array.length;
    };

    public static void main(String[] args) {
        double[] test = { 1.0, 2.0, 3.0, 4.0, 5.0 };
        System.out.println(maxArray.apply(test));
        System.out.println(min.apply(test));
        System.out.println(sum.apply(test));
        System.out.println(average.apply(test));
    }

}