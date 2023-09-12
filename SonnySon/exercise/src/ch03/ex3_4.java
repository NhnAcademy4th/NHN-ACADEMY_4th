package ch03;

import java.util.Scanner;
import java.util.StringTokenizer;

public class ex3_4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // He said, "That's not a good idea.""
        char[] txt = sc.nextLine().toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < txt.length; i++) {
            if ((txt[i] >= 'a' && txt[i] <= 'z') || (txt[i] >= 'A' && txt[i] <= 'Z')) {
                sb.append(txt[i]);
            } else {
                sb.append(" ");
            }
        }

        StringTokenizer st = new StringTokenizer(sb.toString());

        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }

        sc.close();
    }
}
