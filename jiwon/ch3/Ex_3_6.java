package ch3;

public class Ex_3_6 {
    public static void main(String[] args) {
        int num;
        int maxDivisors; // 가장 큰 약수
        int numWithMax;
        int[] saveDivisor = new int[10001];

        maxDivisors = 1;
        numWithMax = 1;

        for (num = 0; num <= 10000; num++) {
            int divisorCount = 0;

            for (int i = 1; i <= num; i++) {
                if (num % i == 0) {
                    divisorCount++;
                }
            }
            saveDivisor[num]=divisorCount;

            if (divisorCount > maxDivisors) {
                maxDivisors = divisorCount;
                numWithMax = num;
            }


        }
        System.out.println("최대 약수의 개수는 " + maxDivisors);
        System.out.println("최대 약수의 개수가 " + maxDivisors + "인 숫자는 " + numWithMax);

        System.out.println("최대 개수를 갖는 모든 숫자는 ");
        for (num = 1; num <= 10000; num++) {
            if (saveDivisor[num] == maxDivisors) {
                System.out.println(" " + num);
            }
        }
    }
}
