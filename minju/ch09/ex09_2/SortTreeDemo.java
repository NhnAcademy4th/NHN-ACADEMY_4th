package ex09_2;

import java.io.BufferedWriter;
import java.io.IOException;

public class SortTreeDemo {

    private TreeNode root;

    public void treeInsert(String newItem) {
        if (root == null) {
            root = new TreeNode(newItem);
            return;
        }
        TreeNode runner;
        runner = root;
        while (true) {
            if (newItem.compareTo(runner.item) < 0) {
                if (runner.left == null) {
                    runner.left = new TreeNode(newItem);
                    return;
                } else
                    runner = runner.left;
            } else {
                if (runner.right == null) {
                    runner.right = new TreeNode(newItem);
                    return;
                } else
                    runner = runner.right;
            }
        }
    }

    /**
     * Return true if item is one of the items in the binary
     * sort tree to which root points. Return false if not.
     */
    public boolean treeContains(TreeNode root, String item) {
        if (root == null) {
            return false;
        } else if (item.equals(root.item)) {
            return true;
        } else if (item.compareTo(root.item) < 0) {
            return treeContains(root.left, item);
        } else {
            return treeContains(root.right, item);
        }
    }

    public void treeList(TreeNode node) {
        if (node != null) {
            treeList(node.left);
            System.out.println("  " + node.item);
            treeList(node.right);
        }
    }

    public void treeList(TreeNode node, BufferedWriter bw) throws IOException {
        if (node != null) {
            treeList(node.left, bw);
            bw.write(node.item + "\n");
            treeList(node.right, bw);
        }
    }

    /**
     * Count the nodes in the binary tree.
     * 
     * @param node A pointer to the root of the tree. A null value indicates
     *             an empty tree.
     * @return the number of nodes in the tree to which node points. For an
     *         empty tree, the value is zero.
     */
    public int countNodes(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            int leftCount = countNodes(node.left);
            int rightCount = countNodes(node.right);
            return 1 + leftCount + rightCount;
        }
    }

    public TreeNode getRoot() {
        return root;
    }

}