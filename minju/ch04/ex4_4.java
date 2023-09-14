public class ex4_4 {

    public static final int ROLL_DICE = 10000;

    public static double rollDiceAverage(int number) {

        double count = 0;
        for (int i = 0; i < ROLL_DICE; i++) {
            int thisCount = ex4_3.diceSum(number);
            count += thisCount;
        }

        return count / ROLL_DICE;

    }

    public static void main(String[] args) {
        System.out.println("주사위 합           평균 횟수");
        System.out.println("----------------------------");
        for (int i = 2; i <= 12; i++) {
            System.out.println(i + "                   " + rollDiceAverage(i));
        }
    }
}
