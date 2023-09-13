package algorithm;

public class Alphabet {
    public static String solution(String str) {
        char[] arr = str.toCharArray();
        StringBuilder result = new StringBuilder();

        for (char c : arr) {
            // 대문자인 경우 A == 65
            if (65 <= c && c <= 90) {
                result.append((char) (c + 32));
            }
            // 소문자인경우 a == 97
            else if (96 < c && c < 123) {
                result.append((char) (c - 32));
            }
            // 특수 문자인 경우
            else {
                result.append(c);
            }
        }
        return result.toString();
    }
}