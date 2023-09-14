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

        boolean foundFirstLetter = false;

        while (st.hasMoreTokens()) {
            for (char c : st.nextToken().toCharArray()) {
                if (Character.isLetter(c)) {
                    if (!foundFirstLetter) {
                        result.append(Character.toUpperCase(c));
                        foundFirstLetter = true;
                    } else result.append(c);
                } else {
                    result.append(c);
                }
            }
            result.append(" ");
            foundFirstLetter = false;
        }
        return result.toString();
    }
}
