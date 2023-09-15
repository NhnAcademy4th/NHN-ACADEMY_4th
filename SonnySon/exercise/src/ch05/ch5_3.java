package ch05;

import ch05.resource.PairOfDice;
import ch05.resource.StatCalc;


public class ch5_3 {

    public static void main(String[] args) {

        // 원하는 숫자가 나올때까지 돌린 주사위의 합계가 들어있는 리스트
        StatCalc[] diceCalc = new StatCalc[13];

        // 주사위 굴린 횟수
        double count;

        PairOfDice dice = new PairOfDice();


        // 경우의 수는 2 ~ 12
        for(int i = 2; i<13; i++){
            // 한 경우의 수에 대해 10000번 반복
            diceCalc[i] = new StatCalc();
            for (int j = 0; j < 10000; j++) {
                // 카운트 초기화
                count = 0;

                while(true){
                    // 주사위를 굴린다.
                    dice.roll();
                    count++;
                    // 주사위의 합이 경우의수와 같으면 굴린 횟수를 계산기에 넣어준다.
                    if(i == dice.getDie1() + dice.getDie2()){
                        diceCalc[i].enter(count);
                        break;
                    }
                }
            }
        }

        System.out.println("경우의수   평균롤수       표준편차           최대롤수");
        for (int i = 2; i < 13; i++) {
            System.out.println(i +" : "+ diceCalc[i].getMean() +"     "+diceCalc[i].getStandardDeviation()+"      "+
                    diceCalc[i].getMax());
        }
    }
}
