package weeklyProblem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Dictionary {

    private Map<String,Set<String>> dictionary = new TreeMap<>();

    public Dictionary(String fileName) throws FileNotFoundException {
        registryDictionary(fileName);
    }

    public void search(String searchWord){
        Set<String> meanings = dictionary.get(searchWord);

        if (meanings != null) {
            System.out.println("검색어: " + searchWord);
            System.out.println("의미: " + meanings);
        } else {
            System.out.println(searchWord + "를 찾을 수 없습니다.");
        }
    }

    private void registryDictionary(String fileName) throws FileNotFoundException {
        String path = Dictionary.class.getResource("").getPath();
        long time = System.currentTimeMillis();
        System.out.println("Dictionary loading");
        Scanner sc = new Scanner(new File(path + fileName));

        while(sc.hasNextLine()){
            String line = sc.nextLine();
            line = line.substring(line.indexOf(".")+2).replaceAll("\t+"," ");

            String name = line.substring(0,line.indexOf(" "));

            String[] means = line.substring(line.indexOf(name)+name.length()).split(",");

            for (int i = 0; i < means.length; i++) {
                means[i] = means[i].trim();
            }
            Set<String> meanings = new HashSet<>(Arrays.asList(means));
            this.dictionary.put(name,meanings);
        }
        sc.close();
        System.out.println("... complete "+ (System.currentTimeMillis() - time) +"ms");
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Dictionary dictionary = null;

        try{
            dictionary = new Dictionary("words.txt");
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }

        while(true){
            System.out.println("검색할 단어 입력 (종료 = enter)");
            String userInputWord = sc.nextLine();

            if(userInputWord.isEmpty()){
                break;
            }

           dictionary.search(userInputWord);
        }
    }
}
