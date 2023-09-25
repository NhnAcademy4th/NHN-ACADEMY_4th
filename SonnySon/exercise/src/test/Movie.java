package test;

public class Movie {
    long MovieID;
    String Title;
    String KoreanTitle;
    String Plot;
    int ReleaseYear;
    int RunningTime;
    int GradeID;

    public String getTitle() {
        return Title;
    }

    public String getKoreanTitle() {
        return KoreanTitle;
    }

    String GradeInKoreaID;
    String Poster;
    String ReleaseDateInKorea;
    long BoxOfficeWWGross;
    long BoxOfficeUSGross;

    @Override
    public String toString() {
        return "Movie{" +
                "MovieID=" + MovieID +
                ", Title='" + Title + '\'' +
                ", KoreanTitle='" + KoreanTitle + '\'' +
                ", Plot='" + Plot + '\'' +
                ", ReleaseYear=" + ReleaseYear +
                ", RunningTime=" + RunningTime +
                ", GradeID=" + GradeID +
                ", GradeInKoreaID='" + GradeInKoreaID + '\'' +
                ", Poster='" + Poster + '\'' +
                ", ReleaseDateInKorea='" + ReleaseDateInKorea + '\'' +
                ", BoxOfficeWWGross=" + BoxOfficeWWGross +
                ", BoxOfficeUSGross=" + BoxOfficeUSGross +
                ", Budget=" + Budget +
                ", OriginalAuthor='" + OriginalAuthor + '\'' +
                ", OriginalSource='" + OriginalSource + '\'' +
                '}';
    }

    int Budget;
    String OriginalAuthor;
    String OriginalSource;

    public Movie(String title, String koreanTitle, String plot, int releaseYear, int runningTime, int gradeID, String gradeInKoreaID, String poster, String releaseDateInKorea, long boxOfficeWWGross, long boxOfficeUSGross, int budget, String originalAuthor, String originalSource) {
        Title = title;
        KoreanTitle = koreanTitle;
        Plot = plot;
        ReleaseYear = releaseYear;
        RunningTime = runningTime;
        GradeID = gradeID;
        GradeInKoreaID = gradeInKoreaID;
        Poster = poster;
        ReleaseDateInKorea = releaseDateInKorea;
        BoxOfficeWWGross = boxOfficeWWGross;
        BoxOfficeUSGross = boxOfficeUSGross;
        Budget = budget;
        OriginalAuthor = originalAuthor;
        OriginalSource = originalSource;
    }
}
