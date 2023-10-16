package ex10_5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ex10_5 {

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

    public static void main(String[] args) {

        System.out.println(count());
        System.out.println(average());
        System.out.println(countA());
        System.out.println(failList());
        
        System.out.print("성씨 순 정렬 : ");
        sortList((s1, s2) -> s1.getlastName().compareTo(s2.getlastName()))
                .forEach(System.out::println);

        System.out.print("점수 순 정렬 : ");
        sortList((s1, s2) -> s1.getScore() - s2.getScore())
                .forEach(System.out::println);

    }

    public static long count() {
        return Arrays.stream(scoreData).count();
    }

    public static double average() {
        return Arrays.stream(scoreData).parallel()
                .mapToInt(ScoreInfo::getScore)
                .average()
                .getAsDouble();
    }

    public static long countA() {
        return Arrays.stream(scoreData).parallel()
                .filter(s -> s.getScore() >= 90)
                .count();
    }

    public static List<String> failList() {
        return Arrays.stream(scoreData).parallel()
                .filter(s -> s.getScore() < 70)
                .map(s -> s.getlastName() + " " + s.getFirstName())
                .collect(Collectors.toList());
    }

    public static Stream<ScoreInfo> sortList(Comparator<ScoreInfo> comparator) {
        return Arrays.stream(scoreData).sorted(comparator);
    }
}
