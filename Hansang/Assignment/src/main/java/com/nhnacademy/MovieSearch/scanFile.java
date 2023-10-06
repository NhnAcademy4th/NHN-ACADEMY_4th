package com.nhnacademy.MovieSearch;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;


public class scanFile {
    private static String firstLine;

    public static void getFirstLine(){
        String[] firstLiner = firstLine.split(",");
        for(String str : firstLiner){
            System.out.print(str + "    ");
        }
        System.out.println("----------------------------------------------------------------------------------------");
    }
    public static List<Movie> parse(String fileName) throws IOException {
        Scanner scanner = new Scanner(new File(fileName));
        List<Movie> movies = new ArrayList<>();
        long movieID;
        String str;
        firstLine = scanner.nextLine();

        while (scanner.hasNextLine()) {
            str = scanner.nextLine();
            String[] strList = StringUtils.split(str, ",");

            movieID = Long.parseLong(strList[0]);
            List<String> detailData = new ArrayList<>();

            for (int i = 1; i < strList.length; i++) {
                detailData.add(strList[i]);

                if(strList[i].contains("...")){
                    str = scanner.nextLine();
                    strList = StringUtils.split(str, ",");

                    for (int j = 0; j < strList.length; j++) {
                        detailData.add(strList[i]);
                    }
                }
            }
            movies.add(new Movie(movieID, detailData));
        }
        return movies;
    }
}
