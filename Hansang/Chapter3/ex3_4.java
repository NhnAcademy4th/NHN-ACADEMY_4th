package Chapter3;

import java.util.Scanner;

public class ex3_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

            for(char c : str.toCharArray())
                if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')){
                    System.out.print(c);
            }else if(c == ' '){
                    //정규표현식을 이용해 보시오
                    System.out.println();
                }

        sc.close();
    }
}
