
public class ex3_2 {
    public static void main(String[] args) {
        int maxDivisor = 0;
        int maxDivisorNum = 2;

        for (int i = 2; i <= 10000; i++) {
            int count = 0;

            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    count++;
                }
            }

            if (maxDivisor < count) {
                maxDivisor = count;
                maxDivisorNum = i;
            }
        }

        System.out.println(maxDivisor);
        System.out.println(maxDivisorNum);
    }

}
