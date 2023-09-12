public class Ex_2_2 {
    public static void main(String[] args) {
        int die1;
        int die2;
        int roll;

        die1 = (int) (Math.random() * 6) + 1;
        die2 = (int) (Math.random() * 6) + 1;
        roll = die1 + die2;

        System.out.println("첫 번째 주사위가 나옵니다. " + die1);
        System.out.println("두 번째 주사위가 나옵니다. " + die2);
        System.out.println("총 주사위 값은 " + roll);

    }

}
