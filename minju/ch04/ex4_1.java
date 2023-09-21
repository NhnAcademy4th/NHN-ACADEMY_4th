import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex4_1 {

    public static void printCapitalized(String sentence) {
        boolean isBlank = true;
        for (int i = 0; i < sentence.length(); i++) {

            char character = sentence.charAt(i);

            if (isBlank && Character.isLetter(character)) {
                System.out.print(Character.toUpperCase(character));
            } else {
                System.out.print(character);
            }

            if (character == ' ') {
                isBlank = true;
            } else {
                isBlank = false;
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("문장을 입력해주세요 : ");
        printCapitalized(br.readLine());
        br.close();
    }

}