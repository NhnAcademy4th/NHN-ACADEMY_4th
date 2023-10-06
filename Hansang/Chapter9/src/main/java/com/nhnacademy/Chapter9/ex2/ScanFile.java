package com.nhnacademy.Chapter9.ex2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScanFile {

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

    public static void InsertData(String fileName) {
        try {
            for (String str : parse(fileName)) {

                if (!TreeNode.containTree(TreeNode.getRoot(), str)) {
                    TreeNode.insertTree(str);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
