package com.nhnacademy;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ex4_3 {

    //한쌍의 주사위가 나와야함
    //한쌍의 주사위의 총합이 init num 과 일치해야함
    //init num은 함수의 입력변수
    //시도횟수를 반환한다.
    //가능한 조합이 아닐떄 exception을 던진다.
    //뱀눈을 얻는 경우를 보여라

    public static int pairDice(int num) {
        boolean isValidRange = (num < 2 || num > 12);

        if(isValidRange) {
            throw new IllegalArgumentException("Total must between 2 to 12!");
        }

        int rand1;
        int rand2;
        int count = 0;

        while(true) {
            rand1 = (int) (Math.random() * 6) + 1;
            rand2 = (int) (Math.random() * 6) + 1;
            count++;
                if((rand1 + rand2) == num){
                    break;

            }
        }
        return count;
    }

    public static void main(String[] args) {
        int num = pairDice(12);
        System.out.println(num);
    }

}
