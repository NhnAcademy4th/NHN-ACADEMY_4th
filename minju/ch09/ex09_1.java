import java.math.BigInteger;

/**
 * ex09_1
 */
public class ex09_1 {

    private static BigInteger one = BigInteger.valueOf(1L);
    private static BigInteger two = BigInteger.valueOf(2L);

    public static void main(String[] args) {
        System.out.println(factorial(BigInteger.valueOf(2L)));
        System.out.println(fibonacci(BigInteger.valueOf(10L)));
    }

    public static BigInteger factorial(BigInteger number) {
        if (number.signum() == -1)
            throw new IllegalArgumentException("factorial : number < 0");
        if (number.signum() == 0)
            return one;
        return number.multiply(factorial(number.subtract(one)));
    }

    public static BigInteger fibonacci(BigInteger number) {
        if (number.signum() == -1)
            throw new IllegalArgumentException("fibonacci : number < 0");
        if (number.signum() == 0)
            return BigInteger.valueOf(0);
        if (number.equals(one) || number.equals(two))
            return one;
        return fibonacci(number.subtract(one)).add(fibonacci(number.subtract(two)));
    }

}