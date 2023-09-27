import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieSearchShell {
    private static MovieDatabase movieDatabase = new MovieDatabase();

    public static void main(String[] args) {
        generateMovieDatabase();
        Scanner scanner = new Scanner(System.in);
        searchMovie(scanner);
        scanner.close();
    }

    public static void generateMovieDatabase() {
        final String FILE_PATH = "./src/Movie.csv";
        try {
            movieDatabase.parse(loadFile(FILE_PATH));
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다.");
            System.exit(0);
        }
    }

    public static List<String> loadFile(String filePath) throws FileNotFoundException {
        Scanner reader = new Scanner(new File(filePath));
        List<String> lines = new ArrayList<>();
        reader.nextLine();
        while (reader.hasNext()) {
            StringBuilder line = new StringBuilder(reader.nextLine());
            if (line.toString().endsWith("...")) {
                line.append(reader.nextLine());
            }
            lines.add(line.toString());
        }
        reader.close();
        return lines;
    }

    public static void searchMovie(Scanner scanner) {
        String movieToSearch;
        while (true) {
            System.out.print("검색할 영화를 영어 제목으로 입력하세요.(exit()를 입력하면 프로그램이 종료됩니다.) : ");
            movieToSearch = scanner.nextLine();
            if (movieToSearch.equals("exit()")) {
                System.out.println("프로그램이 종료됩니다.");
                break;
            }
            try {
                for (Movie movie : movieDatabase.getMovies(movieToSearch)) {
                    movie.printMovieInfoToShell();
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
