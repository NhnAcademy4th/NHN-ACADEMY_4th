public class ex3_6 {

    private static int maxDivisor = 1;
    private static int[] saveDivisors = new int[10001];

    public static void main(String[] args) {

        countDivisors();
        printMaxDivisors();

    }

    private static void printMaxDivisors() {
        System.out.println("Among integers between 1 and 10000,");
        System.out.println("The maximum number of divisors was " + maxDivisor);
        System.out.println("Numbers with that many divisors include");
        for (int i = 0; i < saveDivisors.length; i++) {
            if (saveDivisors[i] == maxDivisor) {
                System.out.println(i);
            }
        }
    }

    private static void countDivisors() {
        saveDivisors[1] = 1;
        for (int i = 2; i < saveDivisors.length; i++) {
            saveDivisors[i] = divisors(i);

            if (saveDivisors[i] > maxDivisor) {
                maxDivisor = saveDivisors[i];
            }
        }
    }

    private static int divisors(int number) {
        int count = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                count++;
            }
        }
        return count;
    }

}
