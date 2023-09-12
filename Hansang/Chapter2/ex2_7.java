package com.Chapter2.Chapter2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ex2_7 {
    public static void main(String[] args) throws IOException {
        String path = "./src/main/java/com/Chapter2/note.txt";

        Scanner sc = new Scanner(new File(path));

        String[] str = new String[5];
        int i = 0;

        while(sc.hasNextLine()){
              i++;
            str[i] = sc.nextLine();
            System.out.println(str[i]);
        }
        Double average = (Double.parseDouble(str[2]) + Double.parseDouble(str[3]) + Double.parseDouble(str[4])) / 3;

        System.out.printf("Average score : %1.2f", average );


    }
}
