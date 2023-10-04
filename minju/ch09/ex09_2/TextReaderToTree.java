package ex09_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.StringTokenizer;

public class TextReaderToTree {
    SortTreeDemo words;

    public TextReaderToTree(String filepath) throws IOException {
        this.words = new SortTreeDemo();
        readFile(filepath);
    }

    private void readFile(String filepath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(new File(filepath)))) {
            String line = br.readLine();
            while (line != null) {
                StringTokenizer st = new StringTokenizer(line, " ");
                appendtoTree(st);
                line = br.readLine();
            }
        }
    }

    private void appendtoTree(StringTokenizer st) {
        while (st.hasMoreTokens()) {
            String word = st.nextToken().toLowerCase();
            if (Objects.isNull(words.getRoot()))
                words.treeInsert(word);
            else if (!words.treeContains(words.getRoot(), word)) {
                words.treeInsert(word);
            }
        }
    }

    public void writeFile(String filepath) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filepath)))) {
            words.treeList(words.getRoot(), bw);
            bw.flush();
        }
    }
}
