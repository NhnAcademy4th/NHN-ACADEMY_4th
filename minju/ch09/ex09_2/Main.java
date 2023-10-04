package ex09_2;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            TextReaderToTree tr = new TextReaderToTree(System.getProperty("user.dir") + "/ex09_2/test.txt");
            tr.writeFile(System.getProperty("user.dir") + "/ex09_2/result.txt");
        } catch (IOException e) {
            System.out.println("파일을 찾을 수 없습니다.");
        }
    }
}
