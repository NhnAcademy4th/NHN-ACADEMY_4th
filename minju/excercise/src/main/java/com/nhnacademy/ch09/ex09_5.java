package com.nhnacademy.ch09;

import java.util.Objects;

public class ex09_5 {
    public static void main(String[] args) {
        SortTree<Integer> test = testTreeNode(1023);
        TreeNode<Integer> root = test.getRoot();
        System.out.println("Max : " + countMaxDepth(root, 0));

        int totalDepth = countTotalDepth(root, 0);
        int leavesNumber = countLeaves(root);
        System.out.println("Total of Depth : " + totalDepth);
        System.out.println("Number of leaves : " + leavesNumber);
        if (leavesNumber != 0)
            System.out.println("Average : " + (double) totalDepth / leavesNumber);
    }

    public static SortTree<Integer> testTreeNode(int number) {
        SortTree<Integer> root = new SortTree<>();
        for (int i = 0; i < number; i++) {
            root.insert((int) (Math.random() * 100));
        }
        return root;
    }

    public static int countMaxDepth(TreeNode<Integer> tree, int count) {
        if (Objects.isNull(tree))
            return count;
        count++;
        int leftCount = countMaxDepth(tree.left, count);
        int rightCount = countMaxDepth(tree.right, count);
        return leftCount >= rightCount ? leftCount : rightCount;
    }

    public static int countTotalDepth(TreeNode<Integer> tree, int count) {
        if (Objects.isNull(tree))
            return 0;
        if (Objects.isNull(tree.left) && Objects.isNull(tree.right))
            count++;
        return count + countTotalDepth(tree.left, count) + countTotalDepth(tree.right, count);
    }

    public static int countLeaves(TreeNode<Integer> tree) {
        if (Objects.isNull(tree)) {
            return 0;
        }
        if (Objects.isNull(tree.left) && Objects.isNull(tree.right)) {
            return 1;
        }
        return countLeaves(tree.left) + countLeaves(tree.right);
    }

}
