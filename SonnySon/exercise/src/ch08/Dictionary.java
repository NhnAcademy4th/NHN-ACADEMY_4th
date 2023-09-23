package ch08;

import java.util.*;

public class Dictionary {
    public static void main(String[] args) {
        Map<String, Set<String>> dictionary = new TreeMap<>();


        String word = "banana";
        Set<String> meanings = new HashSet<>();
        meanings.add("a fruit");
        meanings.add("a song");
        dictionary.put(word,meanings);

        word = "apple";
        meanings = new HashSet<>();
        meanings.add("a fruit");
        meanings.add("a company");
        dictionary.put(word, meanings);

        dictionary.forEach((k,v) ->{
            System.out.println(k);
            for (String a: v
                 ) {
                System.out.println(a);
            }
            }
        );
    }
}
