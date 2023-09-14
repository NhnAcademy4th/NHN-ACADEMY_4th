package Chapter3;

import java.util.Scanner;

public class ex3_3 {
    private static int add(int num1, int num2){
        return num1 + num2;
    }

    private static int sub(int num1, int num2){
        return num1 - num2;
    }

    private static double mul(double num1, double num2) {
        return num1 * num2;
    }
    private static double div(double num1, double num2) {
        return num1 / num2;
    }

    public static void calculater(double num1, double num2, char operator) {
        double result = 0;

        if(operator == '+'){
            System.out.println("calculate " + (int)num1 + operator + (int)num2 +" is "+ add((int)num1, (int)num2));
            //예외 처리문도 추가바람
            //예외 가려줄 수 있는 것은 가려주었으면 좋겠다..
        }   else if(operator == '-'){
            System.out.println("calculate " + (int)num1 + operator + (int)num2 +" is "+ sub((int)num1, (int)num2));
        }   else if(operator == '*'){
            System.out.println("calculate " + num1 + operator + num2 +" is "+ mul(num1, num2));
        }   else if(operator == '/'){
            System.out.println("calculate " + num1 + operator + num2 +" is "+ div(num1, num2));
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("Enter number and operator : ");
            double num1 = sc.nextDouble();
            if(num1 == 0){
                sc.close();
                return;
            }
            char operator = sc.next().charAt(0);
            double num2 = sc.nextDouble();
                calculater(num1, num2, operator);

            //오퍼레이터 예외처리도 추가바람
        }

    }
}
