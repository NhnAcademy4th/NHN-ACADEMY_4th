package com.nhnacademy.Assignment;

public record Movie(
        long movieID,
        String title,
        String titleKR,
        String plot,
        int releaseYear,
        int runningTime,
        int gradeID,
        String gradeIDKR,
        String poster,
        String releasDateInKR,
        long boxOfficeWWGross,
        long boxOfficeUSGross,
        long budget,
        String originalAuthor,
        String originalSource) {

    @Override
    public String toString() {
        return "Movie \n" +
                "movieID=" + movieID + "\n" +
                "title='" + title + "\n" +
                "titleKR='" + titleKR + "\n" +
                "plot='" + plot + "\n" +
                "releaseYear=" + releaseYear + "\n" +
                "runningTime=" + runningTime + "\n" +
                "gradeID=" + gradeID + "\n" +
                "gradeIDKR=" + gradeIDKR + "\n" +
                "poster='" + poster + "\n" +
                "releasDateInKR='" + releasDateInKR + "\n" +
                "boxOfficeWWGross=" + boxOfficeWWGross + "\n" +
                "boxOfficeUSGross=" + boxOfficeUSGross + "\n" +
                "budget=" + budget + "\n" +
                "originalAuthor='" + originalAuthor + "\n" +
                "originalSource='" + originalSource + "\n";
    }

    public Movie {
        if (title == null) {
            throw new IllegalArgumentException("English Title can't be null.");
        }
    }


    @Override
    public String title() {
        return title;
    }

    @Override
    public String titleKR() {
        return titleKR;
    }
}
