package algorithm;

import java.lang.reflect.Array;

public class FibonacciTest {
    private static long Fibonacci(int number){
        switch(number){
            case 0 :
                return 0;
            case 1 :
            case 2 :
                return 1;
            default:
                return Fibonacci(number - 2) + Fibonacci(number - 1);
        }
    }


    public static void main(String[] args) {
        System.out.println(Fibonacci(10));
    }
}
