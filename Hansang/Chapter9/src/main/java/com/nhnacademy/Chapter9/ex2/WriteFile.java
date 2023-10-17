package com.nhnacademy.Chapter9.ex2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class WriteFile {
    public static void getSortedData(String fileName) throws IOException {
        String path = System.getProperty("user.dir");
        File file = new File(path + fileName);


        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            Iterator<TreeNode> nodeIterator = TreeNode.treeList(TreeNode.getRoot());
            while (nodeIterator.hasNext()) {

                String str = nodeIterator.next().getItem();
                bw.write(str + "\n");
            }
            bw.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
