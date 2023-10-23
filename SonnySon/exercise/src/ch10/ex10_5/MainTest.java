package ch10.ex10_5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

record ScoreInfo (
        String firstName,
        String name,
        int score
){}
public class MainTest {
    private static ScoreInfo[] scoreData = new ScoreInfo[]{
            new ScoreInfo("Smith","John",70),
            new ScoreInfo("Doe","Mary",85),
            new ScoreInfo("Page","Alice",82),
            new ScoreInfo("Cooper","Jill",97),
            new ScoreInfo("Flintstone","Fred",66),
            new ScoreInfo("Rubble","Barney",80),
            new ScoreInfo("Smith","Judy",48),
            new ScoreInfo("Dean","James",90),
            new ScoreInfo("Russ","Joe",55),
            new ScoreInfo("Wolfe","Bill",73),
            new ScoreInfo("Dart","Mary",54),
            new ScoreInfo("Rogers","Chris",78),
            new ScoreInfo("Toole","Pat",51),
            new ScoreInfo("Khan","Omar",93),
            new ScoreInfo("Smith","Ann",95)
    };
    public static void main(String[] args) {
        Stream<ScoreInfo> stream = Arrays.stream(scoreData);
        System.out.println("Students : " + stream.count());

        System.out.println("Average : "+Arrays.stream(scoreData)
                .mapToInt(ScoreInfo::score)
                .average().orElseThrow(IllegalAccessError::new));

        System.out.println("number of A grade :"+Arrays.stream(scoreData)
                .map(ScoreInfo::score)
                .filter(score -> score>=90)
                .count());

        List<String> lowGradeStudentStream = Arrays.stream(scoreData)
                .filter(s -> s.score()<70).map(ScoreInfo::name)
                .collect(Collectors.toList());

        System.out.print("lowGrade students : ");
        lowGradeStudentStream.stream()
                .forEach((name) -> System.out.print(name+" "));

        System.out.print("\nSorted by firstName");
        Arrays.stream(scoreData)
                .sorted(Comparator.comparing(ScoreInfo::firstName))
                .forEach((s)-> System.out.print(s.name()+" : "+s.score()+", "));

        System.out.print("\nSorted by score");
        Arrays.stream(scoreData)
                .sorted(Comparator.comparing(ScoreInfo::score))
                .forEach((s) -> System.out.print(s.name()+" : "+s.score()+", "));
    }
}
