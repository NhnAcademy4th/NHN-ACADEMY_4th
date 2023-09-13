package Chapter3;

import java.util.Scanner;

public class ex3_3 {
    public static void calculater(double num1, double num2, char operator) {
        double result = 0;

        if(operator == '+'){
            result = num1 + num2;
            System.out.println("calculate " + (int)num1 + operator + (int)num2 +" is "+ (int)result);
            //예외 처리문도 추가바람
            //예외 가려줄 수 있는 것은 가려주었으면 좋겠다..
        }   else if(operator == '-'){
            result = num1 - num2;
            System.out.println("calculate " + (int)num1 + operator + (int)num2 +" is "+ (int)result);
        }   else if(operator == '*'){
            result = num1 * num2;
            System.out.println("calculate " + num1 + operator + num2 +" is "+ result);
        }   else if(operator == '/'){
            result = num1 / num2;
            System.out.println("calculate " + num1 + operator + num2 +" is "+ result);
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
