
/**
 * ex07_1
 */
public class ex07_1 {

    public static void main(String[] args) {
        testArray(5, 10);
        testArray(11, 11);
        testArray(15, 12);
    }

    public static void testArray(int count, int max) {
        try {
            int[] array = createArray(count, max);
            for (int number : array) {
                System.out.print(number + " ");
            }
            System.out.println();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int[] createArray(int count, int max) {
        if (count > max) {
            throw new IllegalArgumentException("createArray : count > max");
        }

        boolean[] checkValue = new boolean[max];
        int[] array = new int[count];
        int countFill = 0;

        while (countFill != array.length) {
            int number = (int) (Math.random() * max) + 1;
            if (checkValue[number - 1]) {
                continue;
            }
            checkValue[number - 1] = true;
            array[countFill] = number;
            countFill++;
        }

        return array;
    }

}