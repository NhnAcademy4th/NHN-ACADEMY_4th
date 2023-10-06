package com.nhnacademy.Assignment;

import static java.lang.CharSequence.compare;

import java.util.List;


public class SearchEngineShell {
    public void loadEngine() {
        List<Movie> movieList;

        try {
            movieList = scanFile.listingMovies("Movie.csv");
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
            int searchResult;
            if (movieName.toUpperCase().trim().equals("STOP")) {
                Inputshell.scannerClose();
                return;
            }
            if (movieName.isEmpty()) {
                continue;
            }
            searchResult = binSearch(movieName, movieList);

            showResult(searchResult, movieList);
        }
    }
    
    private void showResult(int searchResult, List<Movie> movieList) {
        if (searchResult == -1) {
            System.out.println("no data");
        } else {
            System.out.println(movieList.get(searchResult).toString());
        }
    }

    private int binSearch(String movieName, List<Movie> movieList) {
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
                return node;
            } else if (compareNum < 0) {
                end = node - 1;
            } else {
                start = node + 1;
            }
        }
        return -1;
    }

}
