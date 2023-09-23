package ch08.ex8_4;

import java.util.Scanner;

public class ch8_4 {
    public static void main(String[] args) {
        String line;
        Expr expression;
        double x;
        double val;

        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("fx식을 입력하세요 / 종료하려면 enter");
            line = sc.nextLine().trim();

            if(line.isEmpty()){
                break;
            }

            try{
                expression = new Expr(line);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                continue;
            }

            while(true){
                System.out.println("식에 대입할 x 를 입력하세요 / 종료 enter");
                line = sc.nextLine().trim();
                if(line.isEmpty()){
                    break;
                }
                try{
                    x = Double.parseDouble(line);
                }catch(NumberFormatException e){
                    System.out.println(e.getMessage());
                    continue;
                }

                val = expression.value(x);
                if(Double.isNaN(val)){
                    System.out.println("f("+x+")is undefined");
                }else{
                    System.out.println("f("+x+") = "+val);
                }
            }
        }
    }
}
