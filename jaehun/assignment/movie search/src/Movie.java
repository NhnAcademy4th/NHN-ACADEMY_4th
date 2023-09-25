import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Movie {
    private static final String[] infoOfKind =
            {"MovieID", "Title", "KoreanTitle", "Plot", "ReleaseYear", "RunningTime", "GradeID", "GradeInKoreaID",
                    "Poster", "ReleaseDateInKorea", "BoxOfficeWWGross", "BoxOfficeUSGross", "Budget", "OriginalAuthor",
                    "OriginalSource"};
    private Map<String, String> movieInfo = new LinkedHashMap<>();
    public Movie(List<String> movieInfoList) {
        if (movieInfoList.size() != infoOfKind.length) {
            throw new IllegalArgumentException("파싱이 제대로 이루어지지 않았습니다.");
        }

        for (int i = 0; i < infoOfKind.length; i++) {
            this.movieInfo.put(infoOfKind[i], movieInfoList.get(i));
        }
    }

    public void printMovieInfoToShell() {
        Set<String> infos = movieInfo.keySet();
        for (String info : infos) {
            System.out.println(info + " : " + movieInfo.get(info));
        }
    }
}
