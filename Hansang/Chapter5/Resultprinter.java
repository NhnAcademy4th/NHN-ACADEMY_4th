package com.nhnacademy.Chapter5;

public class Resultprinter {


    //알고리즘 문제에서는 입력 변수의 타입이 integer 타입이기고 ex5_1의 경우 결과가 toString로 string 타입으로 입력되기때문에 오버로딩해줌
    public static void resultLine(int result){
        System.out.println(result);
    }

    public static void resultLine(String result){
        System.out.println(result);
    }

}
