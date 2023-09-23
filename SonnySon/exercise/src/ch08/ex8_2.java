package ch08;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ex8_2 {

    public static long collatzConjecture(String inputNumber){
        if(Long.parseLong(inputNumber)<0){
            throw new IllegalArgumentException("collatzConjecture() : 입력값은 0 보다 커야합니다.");
        }
        if(!isNumber(inputNumber)){
            throw new NumberFormatException("collatzConjectuer() : 유효한 정수값을 입력해야합니다.");
        }
        return collatzConjecture(BigInteger.valueOf(Long.parseLong(inputNumber)),0);
    }

    public static long collatzConjecture(BigInteger inputNumber,int count){
        if(inputNumber.equals(BigInteger.valueOf(1))){
            return count;
        }
        else if(inputNumber.remainder(BigInteger.valueOf(2)).equals(BigInteger.valueOf(0))){
            return collatzConjecture(inputNumber.divide(BigInteger.valueOf(2)),++count);
        }else {
            return collatzConjecture(inputNumber.multiply(BigInteger.valueOf(3)).add(BigInteger.valueOf(1)),++count);
        }
    }

    public static boolean isNumber(String strValue){
        return strValue != null && Pattern.matches("[-+]?\\d+",strValue);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger bi = new BigInteger(sc.next());
        System.out.println(bi);

        while(true){
            try{
                System.out.println("3n - 1 할 정수를 입력하세요. 종료 -> enter");
                String userInput = sc.nextLine();

                if(userInput.isEmpty())
                    break;

                System.out.println("실행 결과 : "+collatzConjecture(userInput));
            }
            catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}