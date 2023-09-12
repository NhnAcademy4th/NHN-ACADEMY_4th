package ch03;

import java.util.Scanner;
import java.util.StringTokenizer;

public class ex3_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());

        // 첫번째 입력
        double sum = Double.parseDouble(st.nextToken());

        sc.close();
        // 첫 입력이 0 인경우 break
        if (sum == 0) {
            throw new IllegalArgumentException();
        }

        while (st.hasMoreTokens()) {
            String value = st.nextToken();
            if (value.equals("+")) {
                sum += Double.parseDouble(st.nextToken());
            } else if (value.equals("-")) {
                sum -= Double.parseDouble(st.nextToken());
            } else if (value.equals("*")) {
                sum *= Double.parseDouble(st.nextToken());
            } else if (value.equals("/")) {
                sum /= Double.parseDouble(st.nextToken());
            } else {
                throw new IllegalArgumentException();
            }
        }
        System.out.println(sum);

    }
}
