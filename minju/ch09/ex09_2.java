import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.StringTokenizer;

public class ex09_2 {

    public static void main(String[] args) {
        SortTree<String> words = new SortTree<>();
        readFile(System.getProperty("user.dir") + "/resources/test.txt", words);
        writeFile(System.getProperty("user.dir") + "/resources/result.txt", words);
    }

    public static void readFile(String filepath, SortTree<String> words) {
        try (BufferedReader br = new BufferedReader(new FileReader(new File(filepath)))) {
            String line = br.readLine();
            while (!Objects.isNull(line)) {
                StringTokenizer st = new StringTokenizer(line, " ");
                appendtoTree(st, words);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void appendtoTree(StringTokenizer st, SortTree<String> words) {
        while (st.hasMoreTokens()) {
            String word = st.nextToken().toLowerCase();
            if (!words.treeContains(words.getRoot(), word)) {
                words.insert(word);
            }
        }
    }

    public static void writeFile(String filepath, SortTree<String> words) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filepath)))) {
            words.printNodes(bw, words.getRoot());
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
