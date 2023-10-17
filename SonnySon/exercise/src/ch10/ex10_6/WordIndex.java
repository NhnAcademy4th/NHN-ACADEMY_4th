package ch10.ex10_6;

import java.util.*;
public class WordIndex {
    static TreeMap<String,TreeSet<Integer>> wordIndex = new TreeMap<>();
    private void readFile(){
        TextIO.fileReader("output.txt");
        TextIO.getln();

        int lineNumber = 0;
        while(!TextIO.EOF()){
            readLine(lineNumber++);
            TextIO.getln();
        }
    }

    private void readLine(int lineNumber){
        while(TextIO.hasNext()){
            String word = readNextWord();
            if(!(word.equals("the") || word.length() < 3)) {
                TreeSet<Integer> lineNumbers = wordIndex.getOrDefault(word,new TreeSet<>());
                lineNumbers.add(lineNumber);
                wordIndex.put(word,lineNumbers);
            }
        }
    }

    private String readNextWord(){
        StringBuilder sb = new StringBuilder();
        char ch = TextIO.next();

        while(Character.isLetter(ch) && TextIO.hasNext()){
            sb.append(ch);
            ch = TextIO.next();
        }
        return sb.toString().toLowerCase();
    }

    public void getIndex(String word){
        if(wordIndex.containsKey(word)){
            System.out.println(wordIndex.get(word));
        }else System.out.println("no index for search Word");
    }

    public void getCount(String word){
        if(wordIndex.containsKey(word)){
            System.out.println(wordIndex.get(word).size());
        }else System.out.println("no Count for search Word");
    }


    public static void main(String[] args) {
        WordIndex wi = new WordIndex();
        wi.readFile();
    }
}

