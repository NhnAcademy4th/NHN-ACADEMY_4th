package com.nhnacademy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inputshell implements AutoCloseable {
    private Scanner sc = new Scanner(System.in);

    public String inputFromShell(String str) {
        System.out.println(str);
        String value;
        value = sc.nextLine();
        value = value.stripLeading();
        if (value.isEmpty()) {
            return "\n";
        }
        return value;
    }

    public List<String> parse(String fileName) throws FileNotFoundException {

        List<String> parsedLines;
        try (Scanner scanner = new Scanner(
                new File(String.valueOf(getClass().getClassLoader().getResource(fileName))))) {
            parsedLines = new ArrayList<>();
            String str;

            while (scanner.hasNextLine()) {
                str = scanner.nextLine();
                parsedLines.add(str);
            }
        }
        return parsedLines;
    }

    @Override
    public void close() throws Exception {
        System.out.println("close");
        sc.close();
    }
}
