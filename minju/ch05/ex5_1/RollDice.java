package ex5_1;

public class RollDice {

    public static int rollForTwo() {
        int count = 0;
        while (true) {
            PairOfDice dices = new PairOfDice();
            int sum = dices.sum();
            count++;
            if (sum == 2) {
                return count;
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(rollForTwo());
    }

}
