package Chapter3;

public class ex3_1 {
    public static void main(String[] args) {

        int count = 0;

        while(true){
            count++;
            int dice1 = (int) (Math.random() * 6 + 1);
            int dice2 = (int) (Math.random() * 6 + 1);

            System.out.println(count+"번째 시도 [ " + dice1 +", " + dice2 + " ]");

            if(dice1 == 1 && dice2 == 1){
                break;
            }
        }


    }
}
