package test;

public record Movie (String title,
                     String koreanTitle,
                     String plot,
                     int releaseYear,
                     int runningTime,
                     int gradeID,
                     String gradeInKoreaID,
                     String poster,
                     String releaseDateInKorea,
                     long boxOfficeWWGross,
                     long boxOfficeUSGross,
                     int budget,
                     String originalAuthor,
                     String originalSource){

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", koreanTitle='" + koreanTitle + '\'' +
                ", plot='" + plot + '\'' +
                ", releaseYear=" + releaseYear +
                ", runningTime=" + runningTime +
                ", gradeID=" + gradeID +
                ", gradeInKoreaID='" + gradeInKoreaID + '\'' +
                ", poster='" + poster + '\'' +
                ", releaseDateInKorea='" + releaseDateInKorea + '\'' +
                ", boxOfficeWWGross=" + boxOfficeWWGross +
                ", boxOfficeUSGross=" + boxOfficeUSGross +
                ", budget=" + budget +
                ", originalAuthor='" + originalAuthor + '\'' +
                ", originalSource='" + originalSource + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public String getKoreanTitle() {
        return koreanTitle;
    }
}
