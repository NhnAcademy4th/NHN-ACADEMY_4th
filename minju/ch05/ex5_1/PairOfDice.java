package ex5_1;

/**
 * PairOfDice
 */
public class PairOfDice {

    private int die1 = (int) (Math.random() * 6) + 1;
    private int die2 = (int) (Math.random() * 6) + 1;

    public int sum() {
        return die1 + die2;
    }

    @Override
    public String toString() {
        return "die1 : " + die1 + "  die2 : " + die2;
    }
}