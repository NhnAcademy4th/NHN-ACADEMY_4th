package test;

import java.io.*;
import java.util.*;

public class MovieParser {
    ArrayList<Movie> movieList;

    public MovieParser(String movieName) throws IOException {
        movieList = movieParsing(movieName);
    }

    public ArrayList<Movie> getMovieList() {
        return movieList;
    }

    public ArrayList<Movie> movieParsing(String fileName) throws IOException {
        List<String> csvList = readCSV(fileName);

        Iterator<String> movies = csvList.iterator();

        ArrayList<Movie> result = new ArrayList<>();

        movies.next();
        while(movies.hasNext()){
            List<String> line = parseLine(movies.next());
            Movie movie = createMovieInstance(line);
            result.add(movie);
            }
        return result;
    }
    private List<String> parseLine(String movieRawInfo) {
        String[] splitedMovieRawInfo = movieRawInfo.split(",");
        List<String> processedMovieInfo = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        for (String info : splitedMovieRawInfo) {
            String pattern = "^(?:\".*?\"|(?!\"|.*\"$).*)$";
            sb.append(info);
            if (sb.toString().matches(pattern)) {
                processedMovieInfo.add(sb.toString());
                sb.setLength(0);
                continue;
            }
            sb.append(",");
        }
        return processedMovieInfo;
    }

    private Movie createMovieInstance(List<String> data) {
        String collons = "^\"|\"$";

        String title = data.get(1).replaceAll(collons,"");
        String koreanTitle = data.get(2).replaceAll(collons,"");
        String plot = data.get(3).replaceAll(collons,"");
        int releaseYear = Integer.parseInt(data.get(4));
        int runningTime = Integer.parseInt(data.get(5));
        int gradeID = Integer.parseInt(data.get(6));
        String gradeInKoreaID = data.get(7).replaceAll(collons,"");
        String poster = data.get(8).replaceAll(collons,"");
        String releaseDateInKorea = data.get(9).replaceAll(collons,"");
        long boxOfficeWWGross = Long.parseLong(data.get(10));
        long boxOfficeUSGross = Long.parseLong(data.get(11));
        int budget = Integer.parseInt(data.get(12));
        String originalAuthor = data.get(13).replaceAll(collons,"");
        String originalSource = data.get(14).replaceAll(collons,"");


        return new Movie(title, koreanTitle, plot, releaseYear, runningTime, gradeID, gradeInKoreaID,
            poster, releaseDateInKorea, boxOfficeWWGross, boxOfficeUSGross, budget, originalAuthor, originalSource);
    }

    public List<String> readCSV(String fileName) throws IOException {
        List<String> csvList = new ArrayList<>();
        String path = MovieParser.class.getResource("").getPath();
        File csv = new File(path + "resource/"+fileName);

        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(csv))) {
            while ((line = br.readLine()) != null) {
                if (line.endsWith("...")) {
                    csvList.add(line + br.readLine());
                    continue;
                }
                csvList.add(line);
            }
        }



        return csvList;
    }

}
