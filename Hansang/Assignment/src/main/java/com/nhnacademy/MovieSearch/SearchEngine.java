package com.nhnacademy.MovieSearch;

import com.nhnacademy.MovieSearch.resource.Inputshell;

import java.util.ArrayList;
import java.util.List;


public class SearchEngine {

    public static void searchName(List<Movie> movieList){
        System.out.println("영화 검색 엔진입니다. 원하시는 영화를 검색해주세요");
        String movieName = Inputshell.inputFromShell(">> ");
        List<Long> keyList = new ArrayList<>();

        keyList = Movie.getIndex(movieName, keyList);

        scanFile.getFirstLine();
        Movie.showResult(keyList);
    }


    public static void main(String[] args) {
        String fileName = "./src/main/java/com/nhnacademy/MovieSearch/resource/Movie.csv";
        List<Movie> movieList;
        try {
            movieList = scanFile.parse(fileName);
            searchName(movieList);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Inputshell.scannerClose();
    }
}
