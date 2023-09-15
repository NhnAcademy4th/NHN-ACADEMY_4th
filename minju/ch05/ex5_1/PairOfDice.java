package ex5_1;

/**
 * PairOfDice
 */
public class PairOfDice {

    private int maxDiceEye = 6;
    private Dice die1 = new Dice(maxDiceEye);
    private Dice die2 = new Dice(maxDiceEye);

    public int sum() {
        return die1.getDiceEye() + die2.getDiceEye();
    }

    public int getMax() {
        return maxDiceEye;
    }

    @Override
    public String toString() {
        return "dice1 : " + die1.toString() + "dice2 : " + die2.toString();
    }
}