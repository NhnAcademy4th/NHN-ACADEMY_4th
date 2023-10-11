package ch09.ex9_4;

import ch09.ex9_2.BinaryTree;

public class MainTest {
    public static void main(String[] args) {
        BinaryTreeUpgrade<String> bt = new BinaryTreeUpgrade();

        bt.treeInsert("사자");
        bt.treeInsert("호랑이");
        bt.treeInsert("개");
        bt.treeInsert("고양이");
        bt.treeInsert("다람쥐");
        bt.treeInsert("악어");
        bt.treeInsert("앵무새");
        bt.treeInsert("거북이");
        bt.treeInsert("얼룩말");

        bt.levelOrderPrint();
    }
}
