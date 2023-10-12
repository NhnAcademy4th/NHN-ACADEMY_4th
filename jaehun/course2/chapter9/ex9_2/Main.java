package course2.chapter9.ex9_2;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        final String INPUT_FILE_PATH = "chapter9/ex9_2/text/wordList.txt";
        final String OUTPUT_FILE_PATH = "chapter9/ex9_2/text/sortedWordList.txt";

        try {
            List<String> words = FileHandler.loadFile(INPUT_FILE_PATH);
            FileHandler.writeToFile(getInorderTree(words), OUTPUT_FILE_PATH);
        } catch (IOException e) {
            System.out.println("파일 읽기/쓰기에 문제가 있습니다.");
        }
    }

    public static String getInorderTree(List<String> words) {
        BinarySortTree binaryTree = new BinarySortTree();
        for (String word : words) {
            binaryTree.insert(word);
        }
        return binaryTree.inorderTree();
    }
}
