
public class ex2_4_1 {

    private static final double QUATER_TO_DOLLAR = 0.25;
    private static final double DIME_TO_DOLLAR = 0.1;
    private static final double NICKEL_TO_DOLLAR = 0.05;
    private static final double PENNY_TO_DOLLAR = 0.01;

    public static void main(String[] args) {

        if (args.length > 4) {
            throw new IllegalArgumentException("동전은 4종류 입니다.");
        }

        int[] coins = new int[4];

        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(args[i]);
        }

        double quaters = coins[0] * QUATER_TO_DOLLAR;
        double dimes = coins[1] * DIME_TO_DOLLAR;
        double nickels = coins[2] * NICKEL_TO_DOLLAR;
        double pennies = coins[3] * PENNY_TO_DOLLAR;

        double dollars = quaters + dimes + nickels + pennies;

        System.out.printf("%1.2f", dollars);

    }
}
