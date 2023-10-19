package com.nhnacademy.homework.words;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * WordsDic
 */
public class WordsDic {

    private String filePath;
    private Map<String, String> dictionary;

    public WordsDic(String filePath) {
        try {
            this.filePath = filePath;
            dictionary = new HashMap<>();
            load();
        } catch (IOException e) {
            System.out.println("파일이 존재하지 않습니다.");
        }
    }

    public String searchOf(String word) {
        String mean = dictionary.get(word.replace(" ", ""));
        if (Objects.isNull(mean)) {
            throw new NullPointerException("찾는 단어가 없습니다.");
        }
        return mean;
    }

    private void load() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(new File(filePath)))) {
            String line = br.readLine();
            while (!Objects.isNull(line)) {
                line = line.replace(",", " ");
                String[] word = line.split("\\s+");
                line = br.readLine();
                addWord(word);
            }
        }
    }

    private void addWord(String[] word) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = 1; i < word.length; i++) {
            if (!word[i].matches("[a-zA-Z-()]*$")) {
                break;
            }
            sb.append(word[i]);
            index = i;
        }
        String key = sb.toString().toLowerCase();

        sb = new StringBuilder();
        for (int i = index + 1; i < word.length; i++) {
            if (word[i].matches("[\\d]*$"))
                continue;
            sb.append(word[i] + " ");
        }

        String value = sb.toString();

        dictionary.put(key, value);
    }

}