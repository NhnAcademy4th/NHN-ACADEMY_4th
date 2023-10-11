package ch09.ex9_5;

import ch09.ex9_2.BinaryTree;

public class MainTest {
    public static void main(String[] args) {
        BinaryTreeDepth<Double> binaryTreeDepth = new BinaryTreeDepth();
        for (int i = 0; i < 1023; i++) {
            binaryTreeDepth.treeInsert(Math.random()*1000);
        }
        System.out.println(binaryTreeDepth.countNodes());
    }
}
