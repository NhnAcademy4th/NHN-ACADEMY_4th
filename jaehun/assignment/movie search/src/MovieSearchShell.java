import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieSearchShell {
    private MovieDatabase movieDatabase = new MovieDatabase();

    public void loadFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        List<String> lines = new ArrayList<>();
        reader.readLine();
        String tempLine;
        while ((tempLine = reader.readLine()) != null) {
            StringBuilder line = new StringBuilder(tempLine);
            if (line.toString().endsWith("...")) {
                line.append(reader.readLine());
            }
            lines.add(line.toString());
        }
        reader.close();
        movieDatabase.parse(lines);
    }

    public void searchMovie() {
        Scanner scanner = new Scanner(System.in);
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
        scanner.close();
    }
}
