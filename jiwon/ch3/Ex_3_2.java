package ch3;

public class Ex_3_2 {
    /*
     * 1부터 10000사이에서 제일 큰 약수를 가진 정수와 약수의 개수 구하기
     */

    public static void main(String[] args) {
        int num;
        int maxDivisors; // 가장 큰 약수
        int numWithMax;

        maxDivisors = 1;
        numWithMax = 1;

        for (num = 0; num <= 10000; num++) {
            int divisorCount = 0;

            for (int i = 1; i <= num; i++) {
                if (num % i == 0) {
                    divisorCount++;
                }
            }
            if (divisorCount > maxDivisors) {
                maxDivisors = divisorCount;
                numWithMax = num;
            }

        }
        System.out.println("최대 약수의 개수는 " + maxDivisors);
        System.out.println("최대 약수의 개수가 " + maxDivisors + "인 숫자는 " + numWithMax);


    }
}
