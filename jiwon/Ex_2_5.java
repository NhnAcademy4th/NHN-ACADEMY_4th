import java.util.Scanner;

/* 이 프로그램은 주어진 수의 계란을 계란으로 변환
 * 계란 1342개는 총 9개, 3다스, 10개이다.
 */

public class Ex_2_5 {
    public static void main(String[] args) {
        int egg;
        int gross;
        int extraGross;
        int dozens;
        int extra;

        Scanner scn = new Scanner(System.in);
        System.out.print("달걀 몇 개? ");
        egg = scn.nextInt();

        gross = egg / 144;
        extraGross = egg % 144;
        dozens = extraGross / 12;
        extra = extraGross % 12;

        System.out.println("gross: " + gross);
        System.out.println("dozens: " + dozens);
        System.out.println("extra: " + extra);

        scn.close();

    }
}
