package Chapter3;

public class Quiz3_9 {
    public static void main(String[] args) {
        int rand1 = randMaker(1, 10);
        int rand2;

        do {
             rand2 = randMaker(1, 10);
        }while(rand1 == rand2);


        System.out.println("random number1 : " + rand1 + ", random number2 : " + rand2);
    }

    public static int randMaker(int start, int end){
        int randomNumber = (int) ((Math.random() * end) + start);
        return randomNumber;
    }

}
