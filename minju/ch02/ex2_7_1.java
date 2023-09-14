import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ex2_7_1 {

    private static final String FILE_PATH = "./testdata.txt";

    public static void main(String[] args) {

        try {
            FileReader fileReader = new FileReader(FILE_PATH);
            Scanner scanner = new Scanner(fileReader);

            String name = scanner.nextLine();
            int math = scanner.nextInt();
            int english = scanner.nextInt();
            int history = scanner.nextInt();

            double average = (math + english + history) / 3.0;
            System.out.println(name + " " + average);

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다.");
        }

    }
}
