package ch11.ex11_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;
public class LineCounts {
    private final TreeMap<String,Integer> fileLineCount = new TreeMap<>();
    private Scanner sc = new Scanner(System.in);
    public SortedMap<String,Integer> getFileLineCount(){
        return fileLineCount;
    }
    public void readLn(String... files) throws FileNotFoundException {

        for (String file : files) {
            File directory = new File(System.getProperty("user.dir") +"/ch11/ex11_2/"+ file);
            sc = new Scanner(directory);
            int count = (int) sc.findAll("\n").count() + 1;
            fileLineCount.put(file,count);
        }
    }
    public void close(){
        sc.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        LineCounts lc = new LineCounts();
        lc.readLn(args);
        System.out.println(lc.getFileLineCount());
        lc.close();
        File file = new File(new File(""),"name");
        System.out.println(file);
    }
}