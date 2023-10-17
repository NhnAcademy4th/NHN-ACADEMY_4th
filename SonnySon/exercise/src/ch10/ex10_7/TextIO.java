package ch10.ex10_7;

import java.io.*;
import java.util.Objects;

public class TextIO {
    static String buffer = null;
    static int pos = 0;
    private final static BufferedReader standardInput = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedReader fileInput;
    private static BufferedReader in = standardInput;
    public static String getln(){
        try{
            buffer = in.readLine();
            if(Objects.equals(buffer, "\\s")){
                System.exit(0);
            }
        }catch(IOException ignore){}

        pos = 0;
        return buffer;
    }
    public static void fileReader(String file){
        String path = TextIO.class.getResource("").getPath();
        try{
            in = new BufferedReader(new FileReader(path+file));
        }catch (FileNotFoundException e){
            System.out.println("파일이 존재하지 않습니다.");
            System.exit(0);
        }
    }
    public static boolean EOF(){
        return Objects.isNull(buffer);
    }
    public static boolean hasNext(){
        return pos < buffer.length();
    }

    public static char peek(){

        return hasNext() ? buffer.charAt(pos) : '\n';
    }

    public static char next(){
        return buffer.charAt(pos++);
    }
    public static void trim(){
        buffer = buffer.replaceAll("\\s+","");
    }

    public static String getWord() {
        StringBuilder word = new StringBuilder();
        char ch = TextIO.peek();
        while (!Character.isWhitespace(ch)) {
            word.append(TextIO.next());
            ch = TextIO.peek();
        }
        return word.toString();
    }

    public static double getDouble() {
        StringBuilder word = new StringBuilder();  // The word.
        char ch = TextIO.peek();
        boolean addDot = false;
        while ((Objects.equals(ch,'.') || Character.isDigit(ch))) {
            if(Objects.equals(ch,'.')){
                if(!addDot) {
                    word.append(TextIO.next());
                    addDot = true;
                }else throw new IllegalArgumentException("duplicated dots");
            }else{
                word.append(TextIO.next());
            }
            if(!TextIO.hasNext()) break;
            ch = TextIO.peek();
        }
        return Double.parseDouble(word.toString());
    }
    public static void skipBlanks() {
        char ch = peek();
        while (!EOF() && ch != '\n' && Character.isWhitespace(ch)) {
            pos++;
            ch = buffer.charAt(pos);
        }
    }
}
