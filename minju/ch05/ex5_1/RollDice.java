package ex5_1;

public class RollDice {

    public static int rollTo(int number) {

        if (number < 2) {

        }

        int count = 0;
        int sum;
        do {
            PairOfDice dices = new PairOfDice();
            sum = dices.sum();
            count++;
        } while (sum != number);

        return count;
    }

    public static void main(String[] args) {
        System.out.println(rollTo(2));
    }

}
