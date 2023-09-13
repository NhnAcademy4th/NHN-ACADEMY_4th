package ch03;

public class ex3_2 {

    public static void main(String[] args) {

        // 1-10000 약수가 가장 많은 수 구하기
        int count;

        int max_number = 0;
        int max_count = 0;

        for (int i = 1; i < 10000; i++) {
            count = 0;
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    count++;
                }
            }
            if (count > max_count) {
                max_count = count;
                max_number = i;
            }
        }

        System.out.println(max_number + "," + max_count);

    }

}
