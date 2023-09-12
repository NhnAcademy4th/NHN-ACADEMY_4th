import java.util.Scanner;
import textio.Textio;

public class Ex_2_7 {
    public static void main(String[] args) {
        String name;
        int score1, score2, score3;
        double average;

        Textio.readFile("./ch2/testdata.txt");

        name = Textio.getln();
        score1 = Textio.getlnInt();
        score2 = Textio.getlnInt();
        score3 = Textio.getlnInt();

        average = (score1 + score2 + score3) / 3.0;

        System.out.printf("%s 학생의 평균: %1.1f ", name, average);

    }

}
