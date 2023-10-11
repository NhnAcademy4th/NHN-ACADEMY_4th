package ch09.ex9_5;

import ch09.ex9_2.BinaryTree;

public class BinaryTreeDepth<T extends Comparable<? super T>> extends BinaryTree<T> {
    int maxDept = 0;

    public int getMaxDept(){
        return maxDept;
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
