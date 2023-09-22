package ch08;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ex8_1 {

    /**
     *
     * @param quadraticTerm 2차항
     * @param fisrtTerm 1차항
     * @param constant 상수
     * @return 이차 방정식의 해
     * @throws IllegalArgumentException 2차가 0이거나 판별식이 0보다 작은경우
     */
    static public double root( double quadraticTerm, double fisrtTerm, double constant )
            throws IllegalArgumentException {
        if (quadraticTerm == 0) {
            throw new IllegalArgumentException("A can't be zero.");
        }
        else {
            double disc = fisrtTerm*fisrtTerm - 4*quadraticTerm*constant;
            if (disc < 0)
                throw new IllegalArgumentException("Discriminant < zero.");
            return  (-fisrtTerm + Math.sqrt(disc)) / (2*quadraticTerm);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean isContinue = true;

        double quadraticTerm;
        double firstTerm;
        double constant;

        do {
            try{
                System.out.println("A(2차),B(1차),C(상수) 입력");
                quadraticTerm = sc.nextDouble();
                firstTerm = sc.nextDouble();
                constant = sc.nextDouble();
            }catch(InputMismatchException e){
                System.out.println("InputMismachException : 실수, 또는 정수만 입력 해야 합니다.");
                continue;
            }

            System.out.println("연산 결과 : "+root(quadraticTerm,firstTerm,constant));
            System.out.println("계속 하시겠습니까? continue(아무수나 입력) : no");
            isContinue = !sc.next().equals("no");

        }while(isContinue);

        sc.close();
    }
}
