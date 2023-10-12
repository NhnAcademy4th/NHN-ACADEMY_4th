package ch09.ex9_5;

import ch09.ex9_2.BinaryTree;

public class BinaryTreeDepth<T extends Comparable<T>> extends BinaryTree<T> {
    int maxDept = 0;

    public int getMaxDept(){
        return maxDept;
    }

    public int getReapCount(){
        if(root == null) return 0;

        return ReapCount(root);
    }

    public int ReapCount(TreeNode node){
        if(node == null) return 0;
        else if(node.left == null && node.right == null) return 1;
        else return ReapCount(node.left) + ReapCount(node.right);
    }

    public int sumOfLeafDepths(){
        return sumOfLeafDepths(root,0);
    }
    public int sumOfLeafDepths(TreeNode node, int depth){
        if(node == null) return 0;
        else if(node.left == null && node.right == null) return depth;
        else return sumOfLeafDepths(node.left, depth + 1) + sumOfLeafDepths(node.right, depth + 1);
    }

    @Override
    public void treeInsert(T newItem){
        int dept = 0;

        if(root == null){
            root = new TreeNode(newItem);
            return;
        }

        TreeNode runner = root;

        while(true){
            if(newItem.compareTo(runner.item) < 0){
                if(runner.left == null){
                    runner.left = new TreeNode(newItem);
                    if(this.maxDept < dept) this.maxDept = dept;
                    return;
                }
                else{
                    runner = runner.left;
                    dept++;
                }
            }
            else{
                if(runner.right == null){
                    runner.right = new TreeNode(newItem);
                    if(this.maxDept < dept) this.maxDept = dept;
                    return;
                }
                else{
                    runner = runner.right;
                    dept++;
                }
            }
        }
    }

}
