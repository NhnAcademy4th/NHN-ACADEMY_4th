import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieDatabase {
    private Map<String, Movie> movieDatabase = new HashMap<>();

    private void setMovieDatabase(List<String> processedMovieInfo) {
        String movieEnglishTitle = processedMovieInfo.get(1);
        String movieKoreanTitle = processedMovieInfo.get(2);
        Movie movie = new Movie(processedMovieInfo);
        if (movieEnglishTitle.isEmpty() || movieKoreanTitle.isEmpty()) {
            return;
        }
        movieDatabase.put(movieEnglishTitle, movie);
        movieDatabase.put(movieKoreanTitle, movie);
    }

    public void parse(List<String> readingFile) {
        String pattern = "^(?:\".*?\"|(?!\"|.*\"$).*)$";

        for (String oneLine : readingFile) {
            List<String> processedMovieInfo = parseOneLine(oneLine, pattern);
            try {
                setMovieDatabase(processedMovieInfo);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<String> parseOneLine(String oneLine, String pattern) {
        String findDoubleQuotation = "^\"|\"$";

        String[] splitedOneLineInfo = oneLine.split(",");
        List<String> processedMovieInfo = new ArrayList<>();

        StringBuilder tokenInfo = new StringBuilder();
        for (String info : splitedOneLineInfo) {
            tokenInfo.append(info);
            if (tokenInfo.toString().matches(pattern)) {
                processedMovieInfo.add(tokenInfo.toString().replaceAll(findDoubleQuotation, ""));
                tokenInfo.setLength(0);
                continue;
            }
            tokenInfo.append(",");
        }
        return processedMovieInfo;
    }


    public Movie getMovieInfo(String movieTitle) {
        if (!movieDatabase.containsKey(movieTitle)) {
            throw new IllegalArgumentException("영화가 존재하지 않습니다.");
        }
        return movieDatabase.get(movieTitle);
    }
}
