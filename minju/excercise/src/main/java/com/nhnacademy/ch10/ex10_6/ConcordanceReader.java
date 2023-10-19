package com.nhnacademy.ch10.ex10_6;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class ConcordanceReader {

    private final String filepath;
    private int lineNumber;
    private Map<String, TreeSet<Integer>> concordance;

    public ConcordanceReader(String filepath) throws IOException {
        this.filepath = filepath;
        concordance = new HashMap<>();
        readWords();
    }

    private void readWords() throws IOException {
        lineNumber = 1;
        try (BufferedReader br = new BufferedReader(new FileReader(new File(filepath)))) {
            int character;
            StringBuilder sb = new StringBuilder();
            while ((character = br.read()) != -1) {
                char letter = (char) character;
                if (letter == '\n') {
                    lineNumber++;
                }
                if (!Character.isLetter(letter)) {
                    addConcordance(sb.toString());
                    sb.setLength(0);
                } else {
                    sb.append(letter);
                }
            }
        }
    }

    private void addConcordance(String word) {
        if (concordance.containsKey(word)) {
            concordance.get(word).add(lineNumber);
        } else if (!word.equals("the") && word.length() > 2) {
            TreeSet<Integer> set = new TreeSet<>();
            set.add(lineNumber);
            concordance.put(word, set);
        }
    }

    public void writeTextFile(String filepath) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filepath)))) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, TreeSet<Integer>> entry : concordance.entrySet()) {
                sb.append(entry.getKey());
                for (int number : entry.getValue()) {
                    sb.append(" ").append(number);
                }
                sb.append("\n");
            }
            bw.write(sb.toString());
            bw.flush();
        }
    }

}
