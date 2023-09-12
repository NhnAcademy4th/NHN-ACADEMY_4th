package com.Hansang;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ex2_7 {
    public static void main(String[] args) throws IOException {
        String path = "src/main/java/com/nhnacademy/note.txt";

        Scanner sc = new Scanner(new File(path));

        String[] str = new String[5];
        int i = 0;

        while(sc.hasNextLine()){
              i++;
            str[i] = sc.nextLine();
            System.out.println(str[i]);
        }
        int average = (Integer.parseInt(str[2]) + Integer.parseInt(str[3]) + Integer.parseInt(str[4]))/ 3;

        System.out.println("Average score : " + average);


    }
}
