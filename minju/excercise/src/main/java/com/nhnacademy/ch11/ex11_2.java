package com.nhnacademy.ch11;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class ex11_2 {

    private static final String FILE_NAME = "ex11";

    public static void main(String[] args) {
        URL url = ex11_2.class.getClassLoader().getResource(FILE_NAME);
        if (Objects.nonNull(url)) {
            String filepath = url.getPath();
            printFileLines(filepath);
        }
    }

    public static void printFileLines(String filepath) {

        if (Objects.isNull(filepath)) {
            throw new IllegalArgumentException("readFile : 잘못된 파일 경로가 입력되었습니다.");
        }
        File file = new File(filepath);
        if (file.isDirectory()) {
            for (String fileName : Objects.requireNonNull(file.list())) {
                printFileLines(filepath + File.separator + fileName);
            }
        } else if (file.exists()) {
            try {
                System.out.println(file.getName() + " : " + countLinesOf(file));
            } catch (IllegalArgumentException e) {
                System.out.println(file.getName() + " 을 찾을 수 없습니다.");
            }
        }
    }

    public static int countLinesOf(File file) {
        int count = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while (Objects.nonNull(br.readLine())) {
                count++;
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("countLinesOf : 파일을 찾을 수 없습니다.");
        }
        return count;
    }

}
