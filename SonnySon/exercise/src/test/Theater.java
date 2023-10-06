package test;

import java.io.IOException;
import java.util.*;

public class Theater {
    ArrayList<Movie> movieList;

    public Theater(){
        defineMovie();
        searchByMovieName();
    }

    public void searchByMovieName(){
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("검색할 영화 입력 / 종료 -> enter");
            String userInput = sc.nextLine();

            if(userInput.isEmpty()){
                break;
            }

            movieList.sort((o1, o2) -> compareWord(o1.getTitle(), o2.getTitle()));

            findWord(userInput,0,movieList.size());

        }
        sc.close();
    }

    private void findWord(String userInput,int start,int end) {
        int pivot = (start+end)/2;
        int result = compareWord(userInput,movieList.get(pivot).getTitle());

        switch (result){
            case 0:
                System.out.println(movieList.get(pivot).toString());
                break;
            case -1:
                findWord(userInput,start,pivot);
                break;
            case 1:
                findWord(userInput,pivot,end);
                break;
        }
    }

    private static int compareWord(String word1, String word2) {
        char[] charArray1 = word1.toCharArray();
        char[] charArray2 = word2.toCharArray();

        int shortWordLength = Math.min(charArray1.length, charArray2.length);

        for(int i = 0; i < shortWordLength; i++) {
            if(charArray1[i] != charArray2[i]){
                return charArray1[i] < charArray2[i]? -1 : 1;
            }
        }
        return 0;
    }



    public void defineMovie(){
        MovieParser movieParser = null;

        try{
            movieParser = new MovieParser("Movie.csv");
        }catch(IOException e){
            System.out.println("파일경로 에러");
        }

        movieList = movieParser.getMovieList();
    }

    public static void main(String[] args){
        Theater theater = new Theater();
    }
}
