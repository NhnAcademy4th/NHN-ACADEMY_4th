
public class ex2_4_1 {

    public static void main(String[] args) {

        if (args.length > 4) {
            throw new IllegalArgumentException("동전은 4종류 입니다.");
        }

        int[] coins = new int[4];

        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(args[i]);
        }

        double quater = 0.25;
        double dime = 0.1;
        double nickel = 0.05;
        double penny = 0.01;

        double dollars = coins[0] * quater +
                coins[1] * dime +
                coins[2] * nickel +
                coins[3] * penny;

        System.out.printf("%1.2f", dollars);

    }
}
