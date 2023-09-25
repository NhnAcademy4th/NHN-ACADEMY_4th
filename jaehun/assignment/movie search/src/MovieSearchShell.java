import java.io.FileNotFoundException;
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
        FileReader fileReader;
        final String FILE_PATH = "./src/Movie.csv";
        try {
            fileReader = new FileReader(FILE_PATH);
            movieDatabase.parse(fileReader.getFile());
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다.");
            System.exit(0);
        }
    }

    public static void searchMovie(Scanner scanner) {
        String movieToSearch;
        while (true) {
            System.out.println("검색할 영화를 입력하세요: (exit()를 입력하면 프로그램이 종료됩니다.)");
            movieToSearch = scanner.nextLine();
            if (movieToSearch.equals("exit()")) {
                System.out.println("프로그램이 종료됩니다.");
                break;
            }
            try {
                movieDatabase.getMovieInfo(movieToSearch).printMovieInfoToShell();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
