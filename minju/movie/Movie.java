
import java.util.List;

public class Movie implements Comparable<Movie> {

    private int id;
    private MovieTitle title;
    private String plot;
    private int releaseYear;
    private int runningTime;
    private int gradeID;
    private int gradeInKoreaID;
    private String poster;
    private String releaseDateInKorea;
    private long boxOfficeWWGross;
    private long boxOfficeUSGross;
    private int budget;
    private String originalAuthor;
    private String originalSource;

    public Movie(List<String> information) {

        if (information.size() != 15) {
            throw new IllegalArgumentException("잘못된 정보가 입력되었습니다.");
        }

        this.id = Integer.valueOf(information.get(0));
        title = new MovieTitle(information.get(1), information.get(2));

        this.plot = information.get(3);
        if (!plot.isEmpty())
            plot = plot.substring(1, plot.length());

        this.releaseYear = Integer.valueOf(information.get(4));
        this.runningTime = Integer.valueOf(information.get(5));

        this.gradeID = Integer.valueOf(information.get(6));

        if (information.get(7).equals("NULL"))
            this.gradeInKoreaID = 0;
        else
            this.gradeInKoreaID = Integer.valueOf(information.get(7));

        this.poster = information.get(8);
        this.releaseDateInKorea = information.get(9);
        this.boxOfficeWWGross = Long.parseLong(information.get(10));
        this.boxOfficeUSGross = Long.parseLong(information.get(11));
        this.budget = Integer.valueOf(information.get(12));
        this.originalAuthor = information.get(13);
        this.originalSource = information.get(14);

    }

    @Override
    public int compareTo(Movie movie) {
        return this.title.compareTo(movie.getTitle());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(title);
        sb.append("Release year : " + releaseYear + "\n");
        sb.append("Running time : " + runningTime + "\n");
        sb.append("Grade : " + gradeID + "\n");
        sb.append("Grade in Korea : " + gradeInKoreaID + "\n");
        sb.append("Release in Korea : " + releaseDateInKorea + "\n");
        sb.append("WW Gross : " + boxOfficeWWGross + "\n");
        sb.append("US Gross : " + boxOfficeUSGross + "\n");
        sb.append("Budget : " + budget + "\n");
        sb.append("Original author : " + originalAuthor + "\n");
        sb.append("Original source : " + originalSource + "\n");
        sb.append("Plot : " + plot);
        return sb.toString();
    }

    public MovieTitle getTitle() {
        return title;
    }

}
