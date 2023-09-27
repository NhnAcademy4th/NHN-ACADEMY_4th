package com.nhnacademy.Assignment;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class scanFile {

    public static List<String> parse(String fileName) throws IOException {
        String path = System.getProperty("user.dir");
        File file = new File(path + "/src/main/resources/" + fileName);

        Scanner scanner = new Scanner(file);
        List<String> parsedLines = new ArrayList<>();
        String str;
        str = scanner.nextLine();

        while (scanner.hasNextLine()) {
            str = scanner.nextLine();
            if (str.endsWith("...")) {
                parsedLines.add(str + scanner.nextLine());
                continue;
            }
            parsedLines.add(str);
        }
        return parsedLines;
    }

    public static List<Movie> listingMovies(String fileName) {
        List<String> parsedLines = new ArrayList<>();
        List<Movie> movies = new ArrayList<>();
        String str;
        try {
            parsedLines = parse(fileName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        for (int i = 0; i < parsedLines.size(); i++) {
            str = parsedLines.get(i);
            Movie movie = splitContents(str);
            movies.add(movie);
        }

        return movies;

    }

    private static Movie splitContents(String str) {
        String[] tokens = str.split(",");
        List<String> details = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (String token : tokens) {
            String pattern = "^(?:\".*?\"|(?!\"|.*\"$).*)$";
            sb.append(token);
            if (sb.toString().matches(pattern)) {
                details.add(sb.toString());
                sb.setLength(0);
                continue;
            }
            sb.append(",");
        }
        return wrapMovie(details);
    }

    private static Movie wrapMovie(List<String> details) {
        String colons = "^\"|\"$";
        long movieID = Long.parseLong(details.get(0));
        String title = details.get(1).replaceAll(colons, "");
        String titleKR = details.get(2).replaceAll(colons, "");
        String plot = details.get(3).replaceAll(colons, "");
        int releaseYear = Integer.parseInt(details.get(4));
        int runningTime = Integer.parseInt(details.get(5));
        int gradeID = Integer.parseInt(details.get(6));
        String gradeIDKR = details.get(7).replaceAll(colons, "");
        String poster = details.get(8).replaceAll(colons, "");
        String releasDateInKR = details.get(9).replaceAll(colons, "");
        long boxOfficeWWGross = Long.parseLong(details.get(10));
        long boxOfficeUSGross = Long.parseLong(details.get(11));
        long budget = Long.parseLong(details.get(12));
        String originalAuthor = details.get(13).replaceAll(colons, "");
        String originalSource = details.get(14).replaceAll(colons, "");

        return new Movie(movieID, title, titleKR, plot, releaseYear, runningTime, gradeID, gradeIDKR, poster,
                releasDateInKR, boxOfficeWWGross, boxOfficeUSGross, budget, originalAuthor, originalSource);
    }
}
