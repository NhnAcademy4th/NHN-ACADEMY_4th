package ex5_5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Table {

    private static int userMoney = 100_0000;
    private static int betMoney;

    private Table() {
    }

    public static void startBlackjack() {
        Scanner scanner = new Scanner(System.in);
        while (userMoney > 0) {
            bet();
            BlackJackGame game = new BlackJackGame();
            game.start();
            betCalculate(game);
            if (!isPlayGame()) {
                break;
            }

        }
        System.out.println("게임을 종료합니다.");
        scanner.close();
    }

    private static void bet() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("베팅금액을 입력해주세요 : ");
        try {
            betMoney = scanner.nextInt();
            if (userMoney - betMoney < 0) {
                throw new InputMismatchException();
            }
        } catch (InputMismatchException e) {
            System.out.println("다시 입력해주세요. 잔액 : " + userMoney);
            scanner.nextLine();
            bet();
        }

    }

    private static void betCalculate(BlackJackGame game) {
        if (game.getWinner()) {
            userMoney += betMoney;
        } else {
            userMoney -= betMoney;
        }
    }

    private static boolean isPlayGame() {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("게임을 진행하시겠습니까?");
            String answer = scanner.nextLine().toUpperCase();
            switch (answer) {
                case "Y":
                case "YES":
                    return true;
                case "N":
                case "NO":
                    return false;
                default:
                    System.out.println("다시 입력해주세요. (Y/N)");
            }
        }
    }

}
