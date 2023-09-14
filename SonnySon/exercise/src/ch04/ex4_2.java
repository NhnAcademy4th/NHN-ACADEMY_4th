package ch04;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ex4_2 {
    private static String PATTERN = "^[a-fA-F0-9]*$";

    /**
     * @param str hexValue
     * @return long type Decimal value
     */
    private static long hexValue(String str) {

        if (!Pattern.matches(PATTERN, str)) {
            return -1;
        }
        long result = 0;

        int lengthOfNum = str.length() - 1;

        for (char c : str.toCharArray()) {
            switch (c) {
                case 'A', 'a':
                    result += 10 * (long) (Math.pow(16, lengthOfNum));
                    break;
                case 'B', 'b':
                    result += 11 * (long) (Math.pow(16, lengthOfNum));
                    break;
                case 'C', 'c':
                    result += 12 * (long) (Math.pow(16, lengthOfNum));
                    break;
                case 'D', 'd':
                    result += 13 * (long) (Math.pow(16, lengthOfNum));
                    break;
                case 'E', 'e':
                    result += 14 * (long) (Math.pow(16, lengthOfNum));
                    break;
                case 'F', 'f':
                    result += 15 * (long) (Math.pow(16, lengthOfNum));
                    break;
                default:
                    result += (c - 48) * (long) (Math.pow(16, lengthOfNum));
                    break;
            }
            lengthOfNum--;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();

        System.out.println(hexValue(line));

        sc.close();
    }
}
