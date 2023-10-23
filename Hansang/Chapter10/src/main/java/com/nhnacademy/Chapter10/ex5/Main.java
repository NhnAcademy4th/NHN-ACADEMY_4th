package com.nhnacademy.Chapter10.ex5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Main {
    private static ScoreInfo[] scoreData = new ScoreInfo[] {
            new ScoreInfo("Smith", "John", 70),
            new ScoreInfo("Doe", "Mary", 85),
            new ScoreInfo("Page", "Alice", 82),
            new ScoreInfo("Cooper", "Jill", 97),
            new ScoreInfo("Flintstone", "Fred", 66),
            new ScoreInfo("Rubble", "Barney", 80),
            new ScoreInfo("Smith", "Judy", 48),
            new ScoreInfo("Dean", "James", 90),
            new ScoreInfo("Russ", "Joe", 55),
            new ScoreInfo("Wolfe", "Bill", 73),
            new ScoreInfo("Dart", "Mary", 54),
            new ScoreInfo("Rogers", "Chris", 78),
            new ScoreInfo("Toole", "Pat", 51),
            new ScoreInfo("Khan", "Omar", 93),
            new ScoreInfo("Smith", "Ann", 95)
    };

    private static void modifyRecord() {
        double range = Arrays.stream(scoreData).count();
        System.out.println(range);

        AtomicInteger result = new AtomicInteger();
        Arrays.stream(scoreData).forEach(object -> result.addAndGet(object.score()));
        double totalScore = result.get();

        System.out.println("Average Score : " + (Math.round((totalScore / range) * 100) / 100.0));

        Arrays.stream(scoreData).filter(object -> object.score() >= 90).forEach(System.out::println);
        List<String> names = Arrays.stream(scoreData).filter(object -> object.score() < 70)
                .map(object -> object.lastName() + " " + object.firstName()).collect(Collectors.toList());

        System.out.println("under Score : ");
        names.stream().forEach(System.out::println);

        System.out.println("Sorted by Lastname : ");
        Arrays.stream(scoreData).sorted(Comparator.comparing(ScoreInfo::lastName))
                .forEach(System.out::println);

        System.out.println("Sorted by Score : ");
        Arrays.stream(scoreData).sorted(Comparator.comparingInt(ScoreInfo::score).reversed())
                .forEach(System.out::println);
    }


    public static void main(String[] args) {
        modifyRecord();
    }

}
