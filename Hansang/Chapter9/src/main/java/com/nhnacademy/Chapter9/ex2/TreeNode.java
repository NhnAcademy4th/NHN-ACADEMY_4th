package com.nhnacademy.Chapter9.ex2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TreeNode {
    private String item;
    private TreeNode left;
    private TreeNode right;
    private static TreeNode root;

    public TreeNode(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }

    public static TreeNode getRoot() {
        return root;
    }

    public static void insertTree(String str) {
        if (root == null) {
            root = new TreeNode(str);
            return;
        }
        TreeNode node;
        node = root;
        while (true) {
            if (str.compareTo(node.item) < 0) {
                if (node.left == null) {
                    node.left = new TreeNode(str);
                    return;
                } else {
                    node = node.left;
                }
            } else {
                if (node.right == null) {
                    node.right = new TreeNode(str);
                    return;
                } else {
                    node = node.right;
                }
            }
        }
    }

    public static boolean containTree(TreeNode root, String item) {
        if (root == null) {
            return false;
        } else if (item.equals(root.item)) {
            return true;
        } else if (item.compareTo(root.item) < 0) {
            return containTree(root.left, item);
        } else {
            return containTree(root.right, item);
        }
    }

    private static final List<TreeNode> list = new ArrayList<>();

    public static Iterator<TreeNode> treeList(TreeNode node) {
        if (node != null) {
            treeList(node.left);
            list.add(node);
            treeList(node.right);
        }
        return list.iterator();
    }
}
