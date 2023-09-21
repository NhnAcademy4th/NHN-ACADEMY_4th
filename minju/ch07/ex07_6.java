import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ex07_6 {
    public static void readTextFile(String filepath) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File(filepath)));

        String line = br.readLine();
        ArrayList<String> list = new ArrayList<>();
        while (line != null) {
            StringTokenizer st = new StringTokenizer(line.toLowerCase(), " ");
            appendToList(list, st);
            line = br.readLine();
        }
        br.close();

        writeToFile(list);
    }

    public static void writeToFile(ArrayList<String> list) throws IOException {
        String filepath = System.getProperty("user.dir") + "/result.txt";
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filepath)));
        for (String word : list) {
            bw.write(word + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void appendToList(ArrayList<String> list, StringTokenizer st) {
        while (st.hasMoreTokens()) {
            String word = st.nextToken();
            if (!list.contains(word))
                list.add(word);
        }
    }

    public static void main(String[] args) {
        try {
            readTextFile(System.getProperty("user.dir") + "/test.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
