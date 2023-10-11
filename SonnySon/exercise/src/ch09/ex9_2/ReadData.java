package ch09.ex9_2;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadData {
    public static Iterator<String> reader() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("/Users/sonnyson/Desktop/git/NHN-ACADEMY_4th/SonnySon/exercise/src/ch09/ex9_2/data"));
        List<String> wordArr = new ArrayList<>();
        String str;
        while((str = reader.readLine()) != null){
            wordArr.add(str);
        }
        return wordArr.iterator();
    }

}
