package com.nhnacademy.Chapter11.ex1;

import com.nhnacademy.Inputshell;
import java.io.File;

public class DirectoryList {
    private static void listingFiles(File dir, String fileName) {
        String[] files;
        files = dir.list();
        fileName += " ";
        for (String file : files) {
            File reFile = new File(dir, file);
            if (reFile.isDirectory()) {
                System.out.println(reFile);
                listingFiles(reFile, fileName);
            } else {
                System.out.println(fileName + file);
            }
        }
    }

    private static File setDirectoryPath() {
        String directoryName = null;
        File directory = null;
        try (Inputshell inputshell = new Inputshell()) {
            directoryName = inputshell.inputFromShell("Enter a directory name:");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        if (directoryName != null) {
            directory = new File(directoryName);
        }

        if (!directory.isDirectory()) {
            if (!directory.exists()) {
                System.out.println("There is no such directory!");
            }
            System.out.println("That file is not a directory");
        }

        return directory;
    }

    public static void main(String[] args) {

        File directory = setDirectoryPath();

        listingFiles(directory, "");
    }

}

