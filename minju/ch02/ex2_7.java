import textio.TextIO;

public class ex2_7 {
    public static void main(String[] args) {
        String name;
        int math, english, history;

        TextIO.readFile("./ch02/testdata.txt");
        name = TextIO.getln();
        math = TextIO.getInt();
        english = TextIO.getInt();
        history = TextIO.getInt();

        double average = (math + english + history) / 3;
        System.out.println(name + " " + average);
    }
}
