package chapter2.example;

import textio.TextIO;

public class Ex2_7 {
    public static void main(String[] args) {

        TextIO.readFile("./chapter2/testdata.txt");
        String name = TextIO.getln();
        int exam1 = TextIO.getlnInt();
        int exam2 = TextIO.getlnInt();
        int exam3 = TextIO.getlnInt();
        double average = (exam1 + exam2 + exam3) / (double) 3;
        System.out.println(name + "의 평균점수 : " + average);
    }
}
