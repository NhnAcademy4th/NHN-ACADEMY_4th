package com.example.ch02;

import java.io.FileReader;
import java.util.Scanner;

public class ex2_7 {
    public static void main(String[] args) throws FileNotFoundException {

        FileReader reader = new FileReader(
                "src/main/java/com/example/ch02/testdata.txt");
        // src/main/java/com/example/ch02/testdata.txt

        Scanner sc = new Scanner(reader);
        String name = sc.nextLine();
        int sum = 0;

        while (sc.hasNextLine()) {
            sum += Integer.parseInt(sc.nextLine());
        }

        System.out.println(name + "s average is" + sum / 3);
    }
}
