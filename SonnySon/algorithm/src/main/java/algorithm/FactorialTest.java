package algorithm;

public class FactorialTest {
    private static long Factorial(int number){
        switch(number){
            case 0 :
                return 1;
            default:
                return Factorial(number - 1) * number ;
        }

    }

    public static void main(String[] args) {
        System.out.println(Factorial(5));
    }
}
