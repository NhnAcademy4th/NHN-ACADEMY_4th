import java.io.IOException;
import java.util.Scanner;

public class MovieSearch {
    public static void startMovieShell() {
        try (Scanner scanner = new Scanner(System.in)) {
            MovieList list = MovieParser.load(System.getProperty("user.dir") + "/Movie.csv");
            String answer = "-";
            while (true) {
                System.out.print("검색할 영화를 입력해주세요(enter시 종료) : ");
                answer = scanner.nextLine().toLowerCase();
                if (answer.isEmpty())
                    break;
                printMovie(list, answer);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printMovie(MovieList list, String title) {
        try {
            System.out.println(list.getMovie(title));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
