package com.nhnacademy.ch11;

import java.io.File;
import java.net.URL;
import java.util.Objects;

public class ex11_1 {

    private static final String FILE_NAME = "ex11";

    public static void main(String[] args) {
        URL file = ex11_1.class.getClassLoader().getResource(FILE_NAME);
        try {
            String filepath = Objects.requireNonNull(file).getPath();
            read(filepath);
        } catch (NullPointerException e) {
            System.out.println("파일을 찾을 수 없습니다.");
        }
    }

    public static void read(String directoryName) {
        File directory = new File(directoryName);
        if (directory.isDirectory()) {
            for (String file : directory.list()) {
                read(directoryName + File.separator + file);
            }
        } else {
            if (directory.exists()) {
                System.out.print(directory.getName() + " ");
            }
        }
    }

}