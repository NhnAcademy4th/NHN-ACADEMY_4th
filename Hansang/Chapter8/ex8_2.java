package com.nhnacademy.Chapter8;

import com.nhnacademy.Chapter8.resources.InputShell;
import java.math.BigInteger;
import java.util.Objects;

public class ex8_2 {

    public static void inputBiginteger(String str){
        BigInteger bi;
        try {
            bi = new BigInteger(str);
        }catch (Exception e) {
            throw new NumberFormatException("not BigInteger!");
        }
        boolean isBig = (bi.signum() == -1);
        if(isBig){
            throw new NumberFormatException("input must bigger than zero!");
        }

        int count = collatzConjecture(bi);

        System.out.println(count);
    }

    public static int collatzConjecture(BigInteger bi){
        int count = 0;
        while(true) {
            if (bi.equals(BigInteger.valueOf(1))) {
                break;
            }
            if(bi.testBit(0)){
                bi = bi.multiply(BigInteger.valueOf(3)).add(BigInteger.valueOf(1));
            } else{
                bi = bi.divide(BigInteger.valueOf(2));
            }
            count++;
            System.out.println(bi);
        }
        return count;
    }
    public static void main(String[] args) {
        String str;
        boolean isNull;
        while(true) {
            str = InputShell.inputFromShell("Enter BigIntegerNumber >>");
            isNull = (Objects.equals(str, ""));
            if(isNull){
                break;
            }
            inputBiginteger(str);
        }

        InputShell.scannerClose();
    }
}
