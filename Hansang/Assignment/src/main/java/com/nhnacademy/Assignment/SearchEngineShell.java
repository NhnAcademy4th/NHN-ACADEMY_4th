package com.nhnacademy.Assignment;

import static java.lang.CharSequence.compare;

import com.nhnacademy.Assignment.resource.Inputshell;
import java.util.ArrayList;
import java.util.List;


public class SearchEngineShell {

    List<Movie> searchedData = new ArrayList<>();

    public void loadEngine() {
        String path = "./src/main/java/com/nhnacademy/Assignment/resource/Movie.csv";

        List<Movie> movieList;

        try {
            movieList = scanFile.listingMovies(path);
            movieList.sort((title1, title2) -> compare(title1.title(), title2.title()));
            searchName(movieList);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private void searchName(List<Movie> movieList) {
        while (true) {
            System.out.println("영화 검색 엔진입니다. 원하시는 영화를 검색해주세요..(종료하시려면 \"stop\"를 입력해주세요)");
            String movieName = Inputshell.inputFromShell(">> ");
            List<Movie> searchResult;
            if (movieName.toUpperCase().trim().equals("STOP")) {
                Inputshell.scannerClose();
                return;
            }
            if (movieName.isEmpty()) {
                continue;
            }
            searchedData.clear();
            searchResult = binSearch(movieName, movieList);

            showResult(searchResult);
        }
    }

    private void showResult(List<Movie> searchResult) {
        for (int i = 0; i < searchResult.size(); i++) {
            System.out.println(searchResult.get(i).toString());
        }
    }

    private List<Movie> binSearch(String movieName, List<Movie> movieList) {
        int start = 0;
        int end = movieList.size() - 1;
        int node;
        int compareNum;

        for (; ; ) {
            if (start > end) {
                break;
            }
            node = (start + end) / 2;
            compareNum = movieName.compareTo(movieList.get(node).title());

            if (compareNum == 0) {
                searchedData.add(movieList.get(node));
                if (start == end) {
                    break;
                }
            } else if (compareNum < 0) {
                end = node - 1;
            } else {
                start = node + 1;
            }
        }
        if (searchedData.isEmpty()) {
            System.out.println("no data");
        }

        return searchedData;
    }

}
