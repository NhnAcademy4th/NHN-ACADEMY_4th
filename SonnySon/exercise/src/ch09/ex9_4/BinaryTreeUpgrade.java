package ch09.ex9_4;

import ch09.ex9_2.BinaryTree;

public class BinaryTreeUpgrade<T extends Comparable<? super T>> extends BinaryTree<T> {

//      Add the root node to an empty queue
//          while the queue is not empty:
//              Get a node from the queue
//              Print the item in the node
//              if node.left is not null:
//                  add it to the queue
//              if node.right is not null:
//                  add it to the queue

    public void levelOrderPrint() {
        if (this.root == null) {
            return;
        }

        Queue<TreeNode> queue = new Queue<>();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.dequeue();
            System.out.println(node.item);
            if (node.left != null) {
                queue.enqueue(node.left);
            }
            if (node.right != null) {
                queue.enqueue(node.right);
            }
        }
    }
}
