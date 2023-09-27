import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        MovieSearchShell movieSearchShell = new MovieSearchShell();
        final String FILE_PATH = "./src/Movie.csv";

        try {
            movieSearchShell.loadFile(FILE_PATH);
        } catch (IOException e) {
            System.out.println("파일을 찾을 수 없습니다.");
        }

        movieSearchShell.searchMovie();
    }
}
