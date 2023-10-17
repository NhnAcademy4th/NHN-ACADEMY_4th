package com.nhnacademy.Chapter9.ex4;

import com.nhnacademy.Chapter9.ex2.Main;
import com.nhnacademy.Chapter9.ex2.ScanFile;
import com.nhnacademy.Chapter9.ex2.TreeNode;
import java.util.Objects;

public class QueueMain {
    public static void main(String[] args) {
        try {
            ScanFile.InsertData(Objects.requireNonNull(Main.class.getClassLoader().getResource("words.txt")).getFile());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        TreeNode.treeToQueue(TreeNode.getRoot());
    }
}
