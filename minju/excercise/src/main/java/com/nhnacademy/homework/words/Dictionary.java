package com.nhnacademy.homework.words;

import java.util.Scanner;

public class Dictionary {

    public static void startSearch() {
        WordsDic dictionary = new WordsDic(System.getProperty("user.dir") + "/words.txt");

        try (Scanner scanner = new Scanner(System.in)) {
            String answer = "";
            while (!answer.equals("exit()")) {
                System.out.print("검색할 단어를 입력하세요 : ");
                String word = scanner.nextLine().toLowerCase();
                System.out.println("결과 : " + search(dictionary, word));

                System.out.println("exit()를 입력하면 종료합니다.");
                System.out.print("종료하시겠습니까? : ");
                answer = scanner.nextLine().toLowerCase();
            }
        }
    }

    public static String search(WordsDic dictionary, String word) {
        try {
            return dictionary.searchOf(word);
        } catch (NullPointerException e) {
            return e.getMessage();
        }

    }
}
