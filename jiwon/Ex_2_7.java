import java.util.Scanner;

public class Ex_2_7 {
    public static void main(String[] args) {
        String name;
        int score1;
        int score2;
        int score3;
        double average;

        Scanner scn = new Scanner(System.in);
        System.out.print("이름: ");
        name = scn.next();
        System.out.print("국어: ");
        score1 = scn.nextInt();
        System.out.print("수학: ");
        score2 = scn.nextInt();
        System.out.print("영어: ");
        score3 = scn.nextInt();

        average = (score1 + score2 + score3) / 3;
        System.out.println(average);

        scn.close();
    }

}
