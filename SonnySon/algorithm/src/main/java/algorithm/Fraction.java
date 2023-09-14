package algorithm;

import java.math.BigDecimal;

//[ 조건 ]
//
//        입력 값은 -1 < num < 1 사이 숫자만 생각합니다.
//        무한 소수는 생각하지 않습니다. (나눠 떨어지는 수만 생각)
//        BigDecimal을 사용합니다.
//        Type 변환은 (int)로 변환합니다.


public class Fraction {
    private static int gcd(int number1, int number2) {
        if (number1 % number2 == 0) {
            return number2;
        }

        return gcd(number2, number1 % number2);
    }

    /**
     *
     * @param decimal (BigDecimal)
     * @return  String line of Decimal's fraction
     */
    private static String getDecimalNumber(BigDecimal decimal){
        int numerator = decimal.scaleByPowerOfTen(decimal.scale()).intValue();
        int denominator = (int)Math.pow(10,decimal.scale());

        int gcd = gcd(numerator,denominator);

        return numerator / gcd + "/" + denominator / gcd;
    }

    private final static BigDecimal[] TESTCASE = {
            BigDecimal.valueOf(0.5), BigDecimal.valueOf(0.2), BigDecimal.valueOf(0.032), BigDecimal.valueOf(0.44)
    };

    private final static String[] TESTCASE_ANSWER = new String[] {
            "1/2","1/5","4/125","11/25"
    };

    private static double correct = 0;

    private static void test(BigDecimal input, String output){
        if(output.equals(getDecimalNumber(input))){
            System.out.println(input +" = "+output+" ... true");
            correct++;
        }
    }

    public static void main(String[] args) {
        for(int i = 0; i<TESTCASE.length;i++){
            test(TESTCASE[i],TESTCASE_ANSWER[i]);
        }
        System.out.printf("%1.0f",(correct/TESTCASE.length)*100);
    }
}
