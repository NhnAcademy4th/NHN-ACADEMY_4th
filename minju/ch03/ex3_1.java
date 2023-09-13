
/**
 * ex3_1
 */
public class ex3_1 {

    public static void main(String[] args) {

        int count = 0;

        while (true) {
            int dice1 = (int) (Math.random() * 6) + 1;
            int dice2 = (int) (Math.random() * 6) + 1;
            count++;
            if (dice1 == 1 && dice2 == 1) {
                System.out.println(count);
                break;
            }
        }

    }

}