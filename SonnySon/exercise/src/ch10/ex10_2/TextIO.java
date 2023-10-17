package ch10.ex10_2;

import java.io.*;
import java.util.Objects;

public class TextIO {
    static String buffer = null;
    static int pos = 0;
    private final static BufferedReader standardInput = new BufferedReader(new InputStreamReader(System.in));  // wraps standard input stream
    private static BufferedReader fileInput;
    private static BufferedReader in = standardInput;  // Stream that data is read from; the current input source.

    public static void getln(){    // Wait for user to type a line and press return,
        try{
            buffer = in.readLine();
            if(Objects.equals(buffer, " ")){
                System.exit(0);
            }
        }catch(IOException ignore){}

        pos = 0;
    }
    public static void fileReader(String file){
        String path = TextIO.class.getResource("").getPath();
        try{
            fileInput= new BufferedReader(new FileReader(path+file));
        }catch (FileNotFoundException e){
            System.out.println("파일이 존재하지 않습니다.");
            System.exit(0);
        }
    }


    public static boolean hasNext(){
        return pos < buffer.length();
    }

    public static char peek(){
        return buffer.charAt(pos);
    }

    public static char next(){
        return buffer.charAt(pos++);
    }
    public static void trim(){
        buffer = buffer.replaceAll("\\s+","");
    }
}
