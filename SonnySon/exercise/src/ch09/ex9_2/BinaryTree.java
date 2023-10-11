package ch09.ex9_2;

public class BinaryTree<T extends Comparable<? super T>>{
    protected TreeNode root;
    protected class TreeNode{
        public T item;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(T str){item =str;}

    }

    public void treeInsert(T newItem){
        if(root == null){
            root = new TreeNode(newItem);
            return;
        }
        TreeNode runner = root;
        while(true){
            if(newItem.compareTo(runner.item) < 0){
                if(runner.left == null){
                    runner.left = new TreeNode(newItem);
                    return;
                }
                else
                    runner = runner.left;
            }
            else{
                if(runner.right == null){
                    runner.right = new TreeNode(newItem);
                    return;
                }
                else
                    runner = runner.right;
            }
        }
    }
    public boolean treeContains(TreeNode root, T item ) {
        if ( root == null ) {
            // Tree is empty, so it certainly doesn't contain item.
            return false;
        }
        else if ( item.equals(root.item) ) {
            // Yes, the item has been found in the root node.
            return true;
        }
        else if ( item.compareTo(root.item) < 0 ) {
            // If the item occurs, it must be in the left subtree.
            return treeContains( root.left, item );
        }
        else {
            // If the item occurs, it must be in the right subtree.
            return treeContains( root.right, item );
        }
    }

    public void treeList(){
        treeList(root);
    }

    private void treeList(TreeNode node) {
        if ( node != null ) {
            treeList(node.left);             // Print items in left subtree.
            System.out.println("  " + node.item);  // Print item in the node.
            treeList(node.right);            // Print items in the right subtree.
        }
    }

    public int countNodes(){
        return countNodes(root);
    }

    private int countNodes(TreeNode node) {
        if ( node == null ) {
            // Tree is empty, so it contains no nodes.
            return 0;
        }
        else {
            // Add up the root node and the nodes in its two subtrees.
            int leftCount = countNodes( node.left );
            int rightCount = countNodes( node.right );
            return  1 + leftCount + rightCount;
        }
    }
}
