
import java.util.List;

public class Movie implements Comparable<Movie> {

    private final int id;
    private final String title;
    private final String korTitle;
    private final String plot;
    private final int releaseYear;
    private final int runningTime;
    private final int gradeID;
    private final int gradeInKoreaID;
    private final String poster;
    private final String releaseDateInKorea;
    private final long boxOfficeWWGross;
    private final long boxOfficeUSGross;
    private final int budget;
    private final String originalAuthor;
    private final String originalSource;

    public Movie(List<String> information) {

        if (information.size() != 15) {
            throw new IllegalArgumentException("잘못된 정보가 입력되었습니다.");
        }

        this.id = Integer.parseInt(information.get(0));

        this.title = information.get(1);
        if (title.isEmpty()) {
            throw new IllegalArgumentException("영문 제목은 빈칸으로 둘 수 없습니다.");
        }
        this.korTitle = information.get(2);
        this.plot = information.get(3);

        this.releaseYear = stringToIntValue(information.get(4));

        this.runningTime = stringToIntValue(information.get(5));

        this.gradeID = stringToIntValue(information.get(6));

        this.gradeInKoreaID = stringToIntValue(information.get(4));

        this.poster = information.get(8);
        this.releaseDateInKorea = information.get(9);

        this.boxOfficeWWGross = stringToLongValue(information.get(10));
        this.boxOfficeUSGross = stringToLongValue(information.get(11));
        this.budget = stringToIntValue(information.get(12));
        this.originalAuthor = information.get(13);
        this.originalSource = information.get(14);

    }

    private int stringToIntValue(String value) {
        if (value.isEmpty())
            return 0;
        return Integer.parseInt(value);
    }

    private long stringToLongValue(String value) {
        if (value.isEmpty())
            return 0;
        return Long.parseLong(value);
    }

    @Override
    public int compareTo(Movie movie) {
        return this.title.compareTo(movie.getTitle());
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Title : ");
        sb.append(title);
        sb.append("\n");

        sb.append("Korean Title : ");
        sb.append(korTitle);
        sb.append("\n");

        sb.append("Poster : ");
        sb.append(poster);
        sb.append("\n");

        sb.append("Release year : ");
        sb.append(releaseYear);
        sb.append("\n");

        sb.append("Running time : ");
        sb.append(runningTime);
        sb.append("\n");

        sb.append("Grade : ");
        sb.append(gradeID);
        sb.append("\n");

        sb.append("Grand in Korea : ");
        sb.append(gradeInKoreaID);
        sb.append("\n");

        sb.append("Realease in Korea : ");
        sb.append(releaseDateInKorea);
        sb.append("\n");

        sb.append("WW Gross : ");
        sb.append(boxOfficeWWGross);
        sb.append("\n");

        sb.append("US Gross : ");
        sb.append(boxOfficeUSGross);
        sb.append("\n");

        sb.append("Budget : ");
        sb.append(budget);
        sb.append("\n");

        sb.append("Original author : ");
        sb.append(originalAuthor);
        sb.append("\n");

        sb.append("Original source : ");
        sb.append(originalSource);
        sb.append("\n");

        sb.append("Plot : ");
        sb.append(plot);

        return sb.toString();
    }
}
