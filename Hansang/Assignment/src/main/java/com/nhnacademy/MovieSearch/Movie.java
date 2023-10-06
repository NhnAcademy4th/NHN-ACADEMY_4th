package com.nhnacademy.MovieSearch;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Movie {

    private static Map<Long, List<String>> movie = new HashMap<>();

    public Movie(long movieID, List<String> detailData) {
        movie.put(movieID, detailData);
    }

    public static List<Long> getIndex(String name, List<Long> keyList){
       for(Map.Entry<Long, List<String>> entry : movie.entrySet()){
           if(entry.getValue().contains(name)){
                keyList.add(entry.getKey());
           }
       }
       return keyList;
    }

    public static String getMovie(long key) {
        return movie.get(key).toString();
    }

    public static void showResult (List<Long> keyList){
        for(long index : keyList){
            System.out.println(index + "     " + getMovie(index));
        }
    }

}
