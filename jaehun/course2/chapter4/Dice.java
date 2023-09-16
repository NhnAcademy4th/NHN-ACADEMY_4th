package course2.chapter4;

public class Dice {
    private static int numberOfDice = 2; //주사위 개수
    private static int maxDiceNumber = 6; // 주사위 최대 번호

    public static int getDiceSum() {
        int sum = 0;
        for (int i = 0; i < numberOfDice; i++) {
            sum += getRandomNumber();
        }
        return sum;
    }

    public static int count(int n){
        int count=0;
        while(!isRandomNumSumEqualN(n)){
            count++;
        }
        return count;
    }

    public static boolean isRandomNumSumEqualN(int n){
        if(getDiceSum()==n)
            return true;
        return false;
    }

    public static int getRandomNumber() {
        int randomNumber = (int) (Math.random() * maxDiceNumber) + 1;
        return randomNumber;
    }
}
