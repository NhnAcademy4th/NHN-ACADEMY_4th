package com.nhnacademy;

public class ex4_5{

    private static final ArrayProcessor arrayMax = number ->{
        double MAX_VALUE = Double.MIN_VALUE;
        for (double num : number) {
            boolean isBig = num > MAX_VALUE;
            if (isBig) {
                MAX_VALUE = num;
            }
        }
        return MAX_VALUE;
    };

    public static final ArrayProcessor arrayMin = number ->{
        double MIN_VALUE = Double.MAX_VALUE;
        for (double num : number) {
            boolean isSmall = num < MIN_VALUE;
            if (isSmall) {
                MIN_VALUE = num;
            }
        }
        return MIN_VALUE;
    };
    public static final ArrayProcessor arrayTotal = number -> {
        double totalValue = 0;
        for(double num : number){
            totalValue += num;
        }
        return totalValue;
    };

    public static final ArrayProcessor arrayAverage = number -> {
        return arrayTotal.apply(number) / number.length;
    };


    private static void testExercise(){
        double[] test = {1.0, 2.0, 3.0, 4.0, 5.0};
        System.out.println(arrayMax.apply(test));
        System.out.println(arrayMin.apply(test));
        System.out.println(arrayTotal.apply(test));
        System.out.println(arrayAverage.apply(test));
    }

    //람다식의 경우 컴파일러 스스로 앞서 정의해놓은 타입을 확인하여 적용한다.
    // ArrayProcessor라고 이름지어진 인터페이스의 경우
    //해당 인터페이스 명이 하나의 타입으로 사용되어질 수 있다.
    //apply의 경우 람다식에 적용될 입력변수 타입을 미리 지정하여 람다식을 활용할 때 좀더 축약해도 괜찬도록 만들어준다.
    // 예를 들어 arrayTotal함수의 경우
//    ArrayProcessor ap = number -> {
//        double total =0;
//        for (double num : test) {
//            total += num;
//        }
//        return total;
//    };
    //해당 코드로도 토탈을 받아 올 수 있는 것이다.

    public static void main(String[] args) {
        testExercise();
    }
}