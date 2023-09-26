import java.io.IOException;
import java.util.Scanner;

public class MovieSearchShell {

    private MovieSearchShell() {
    }

    public static void startMovieShell() {
        try (Scanner scanner = new Scanner(System.in)) {
            MovieList list = MovieParser.load(System.getProperty("user.dir") + "/Movie.csv");

            while (true) {
                System.out.print("검색할 영화를 입력해주세요(enter시 종료) : ");
                String answer = scanner.nextLine();
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
            for (Movie movie : list.getMovie(title)) {
                System.out.println(movie);
                System.out.println();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
