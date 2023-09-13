public class Ex_3_1 {
    public static void main(String[] args) {
        int dice1, dice2;
        int countRoll = 0;

        do {
            dice1 = (int) (Math.random() * 6) + 1;
            dice2 = (int) (Math.random() * 6) + 1;
            countRoll++;

        } while (!(dice1 == 1 && dice2 == 1));

        System.out.print("주사위 몇 번 돌았냐? " + countRoll);

    }
}
