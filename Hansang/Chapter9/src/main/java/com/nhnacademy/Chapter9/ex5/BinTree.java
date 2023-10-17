package com.nhnacademy.Chapter9.ex5;

import static com.nhnacademy.Chapter9.ex2.TreeNode.containTree;
import static com.nhnacademy.Chapter9.ex2.TreeNode.countNode;
import static com.nhnacademy.Chapter9.ex2.TreeNode.getAllDepth;
import static com.nhnacademy.Chapter9.ex2.TreeNode.getMaxDepth;
import static com.nhnacademy.Chapter9.ex2.TreeNode.getRoot;

import com.nhnacademy.Chapter9.ex2.TreeNode;

public class BinTree {
    public static void BinTreeInit() {
        int randomInt;
        while (true) {
            randomInt = (int) (Math.random() * 10000 + 1);
            if (containTree(TreeNode.getRoot(), String.valueOf(randomInt))) {
                continue;
            }
            TreeNode.insertTree(String.valueOf(randomInt));
            if (countNode(TreeNode.getRoot()) == 1023) {
                break;
            }
        }

        TreeNode.findMaxDepth(TreeNode.getRoot(), 0);

        int MAX_DEPTH = getMaxDepth();
        System.out.println("Max Depth : " + MAX_DEPTH);

        int allDepth = getAllDepth(getRoot(), 0);
        System.out.println("All Depth : " + allDepth);
        
        int count = countNode(getRoot());
        System.out.println("Leaf count : " + count);
    }

    public static void main(String[] args) {
        BinTreeInit();
    }
}
