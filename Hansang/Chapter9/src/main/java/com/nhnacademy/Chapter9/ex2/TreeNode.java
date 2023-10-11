package com.nhnacademy.Chapter9.ex2;

import com.nhnacademy.Chapter9.ex4.TreeQueue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TreeNode {
    private String item;
    private TreeNode left;
    private TreeNode right;
    private static TreeNode root;

    private static int depth;

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

    public static void treeToQueue(TreeNode node) {
        TreeQueue queue = new TreeQueue();

        queue.insertQueue(node);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.popQueue();
            System.out.println(temp.getItem());

            if (temp.left != null) {
                queue.insertQueue(temp.left);
            }
            if (temp.right != null) {
                queue.insertQueue(temp.right);
            }
        }
    }

    public static int countNode(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            int left = countNode(node.left);
            int right = countNode(node.right);
            return 1 + left + right;
        }
    }

    public static int getDepth() {
        return depth;
    }

    public static void findMaxDepth(TreeNode node, int result) {
        if (node == null) {
            return;
        }
        if (depth < result) {
            depth = result;
        }

        if (node.left != null) {
            findMaxDepth(node.left, result + 1);
        }
        if (node.right != null) {
            findMaxDepth(node.right, result + 1);
        }
    }
}
