package ch04;

import java.util.Scanner;
import java.util.StringTokenizer;

public class ex4_1 {

    //Now is the time to act!
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        System.out.println(printCapitalized(line));

        sc.close();
    }

    /**
     * @param line String value
     * @return First Char and after space Char toUpperCase
     */
    private static String printCapitalized(String line) {

        StringTokenizer st = new StringTokenizer(line);
        StringBuilder result = new StringBuilder();

        boolean isFoundFirstLetter = false;

        while (st.hasMoreTokens()) {
            for (char c : st.nextToken().toCharArray()) {
                if (Character.isLetter(c) == isFoundFirstLetter) {
                        result.append(Character.toUpperCase(c));
                        isFoundFirstLetter = true;
                } else {
                    result.append(c);
                }
            }
            result.append(" ");
            isFoundFirstLetter = false;
        }
        return result.toString();
    }
}
