package ch09.ex9_2;

import java.io.IOException;
import java.util.Iterator;

public class MainTest {
    public static void main(String[] args) throws IOException {
        Iterator<String> iterator = ReadData.reader();

        BinaryTree<String> binaryTree = new BinaryTree();

        while(iterator.hasNext()){
            binaryTree.treeInsert(iterator.next());
        }
        binaryTree.treeList();
    }
}