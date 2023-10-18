package com.nhnacademy.Chapter10.ex6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class ScanFile {


    private static final char EOF = (char) 0xFFFF;
    private static int index;

    public static List<String> parse(String fileName) throws FileNotFoundException {


        List<String> parsedLines;
        try (Scanner scanner = new Scanner(new File(fileName))) {
            parsedLines = new ArrayList<>();
            String str;

            while (scanner.hasNextLine()) {
                str = scanner.nextLine();
                parsedLines.add(str);
            }
        }
        return parsedLines;
    }

    public static TreeMap<String, WordData> InsertData(String fileName) {
        int lineCount = 1;
        TreeMap<String, WordData> words = new TreeMap<>();
        try {
            for (String str : parse(fileName)) {
                index = 0;
                String word;
                while (true) {
                    word = readNextWord(str);
                    if ("Go Next Line".equals(word)) {
                        break;
                    }
                    if (word != null) {
                        word = word.toLowerCase();
                    }
                    if (word.length() <= 3) {
                        continue;
                    }
                    WordData data = words.get(word);
                    if (data == null) {
                        words.put(word, new WordData(word, lineCount));
                    }

                }
                lineCount++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return words;
    }

    private static char lookChar(String buffer, int bufferIndex) {
        if (buffer == null || bufferIndex > buffer.length()) {
            throw new IllegalArgumentException("Data not exist!");
        } else if (bufferIndex == buffer.length()) {
            return '\n';
        } else {
            return buffer.charAt(bufferIndex);
        }
    }

    public static String readNextWord(String str) {
        char ch = lookChar(str, index);
        if (ch == '\n') {
            return "Go Next Line";
        }
        while (ch != EOF && !Character.isLetter(ch)) {
            index++;
            ch = lookChar(str, index);
        }
        if (ch == EOF) {
            return null;
        }
        StringBuilder word = new StringBuilder();
        while (true) {
            word.append(ch);
            index++;
            ch = lookChar(str, index);
            if (ch == '\'' || ch == '?') {
                index++;
                ch = lookChar(str, index);
                if (Character.isLetter(ch)) {
                    word.append("\'");
                    word.append(ch);
                    index++;
                    ch = lookChar(str, index);
                } else {
                    break;
                }
            }
            if (!Character.isLetter(ch)) {
                break;
            }
        }
        return word.toString();
    }

}
