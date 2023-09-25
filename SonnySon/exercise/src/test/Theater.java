package test;

import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Theater {
    public static void main(String[] args){
        Map<String,Movie> movieList = MovieParser.movieParsing();

        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("검색할 영화 입력 / 종료 -> enter");
            String userInput = sc.nextLine();

            if(userInput.isEmpty()){
                break;
            }

            if(movieList.get(userInput) != null){
                System.out.println("찾는 결과 : "+userInput);
                System.out.println(movieList.get(userInput).toString());
            }else
                System.out.println("찾는 결과가 없습니다.");
        }
    }
}
