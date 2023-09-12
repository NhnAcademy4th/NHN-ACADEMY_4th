package ch03;

public class ex3_6 {
    public static void main(String[] args) {

        int[] counts = new int[10000];
        int count;
        int max_count = 0;

        for (int i = 1; i < 10000; i++) {
            count = 0;
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    count++;
                }
            }

            counts[i] = count;

            if (max_count < count) {
                max_count = count;
            }

        }

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == max_count) {
                System.out.println(i);
            }
        }
    }
}
