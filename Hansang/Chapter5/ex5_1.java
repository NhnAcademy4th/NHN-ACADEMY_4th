package com.nhnacademy.Chapter5;

public class ex5_1 {

    private static int countPair(int number, PairOfDice pod) {
        boolean isValidRange = (number >= 2 && number <= 12);

        boolean isTotalsame; // recursiveCounter를 사용하면 해당 변수가 필요없음
        int count = 0;
        int totalCount = 0;


        if (!(isValidRange)) {
            throw new IllegalArgumentException("That number can not be a total!");
        }

        while (true) {
            isTotalsame = ((pod.getDice1() + pod.getDice2()) == number);
            if (isTotalsame) {

                break;
            }

            pod.setDice1();
            pod.setDice2();
            count++;

        }
//        result = recursiveCounter(count, number, pod);
        totalCount = count;

        return totalCount;
    }

    //recursion형식으로 만든 이유
    //recursion형식이면 어떤식으로 작동할지 고민해보고 작성함
//    private static int recursiveCounter(int count, int total, PairOfDice pod){
//        if((pod.getDice1() + pod.getDice2()) == total){
//            return count;
//        }
//        pod.setDice1();
//        pod.setDice2();
//        return recursiveCounter(++count, total, pod);
//    }

    //테스트에서 PairofDice 생성

    public static int Comparedice(int number) {

        PairOfDice pod = new PairOfDice();
        int result = countPair(number, pod);
        //9월15일 알고리즘문제의 최종 출력 부분과 비슷한 구조를 가지고 있기때문에
        //따로 클래스를 생성하여 클래스 명으로 어떤 역활을 하는지 알려주었음
        return result;
    }

    private static void testProblem1() {
        Resultprinter.resultLine(Comparedice(2));

    }

    //main문에서 보여주는 것을 최대한 제거
    public static void main(String[] args) {
        testProblem1();
    }

}
