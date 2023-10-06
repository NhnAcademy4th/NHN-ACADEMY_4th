import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Objects;

public class SortTree<T extends Comparable<T>> {

    private TreeNode<T> root;

    public void insert(T newItem) {
        if (Objects.isNull(root)) {
            root = new TreeNode<>(newItem);
            return;
        }

        TreeNode<T> runner = root;
        while (true) {
            if (newItem.compareTo(runner.getItem()) < 0) {
                if (Objects.isNull(runner.left)) {
                    runner.left = new TreeNode<>(newItem);
                    return;
                } else {
                    runner = runner.left;
                }
            } else {
                if (Objects.isNull(runner.right)) {
                    runner.right = new TreeNode<>(newItem);
                    return;
                } else {
                    runner = runner.right;
                }
            }
        }
    }

    public boolean treeContains(TreeNode<T> root, T item) {
        if (Objects.isNull(root)) {
            return false;
        } else if (item.compareTo(root.getItem()) == 0) {
            return true;
        } else if (item.compareTo(root.getItem()) < 0) {
            return treeContains(root.left, item);
        } else {
            return treeContains(root.right, item);
        }
    }

    public void printNodes(BufferedWriter bw, TreeNode<T> node) throws IOException {
        if (!Objects.isNull(node)) {
            printNodes(bw, node.left);
            bw.write(node.getItem() + "\n");
            printNodes(bw, node.right);
        }
    }

    public int countNodes(TreeNode<T> node) {
        if (node == null) {
            return 0;
        } else {
            int leftCount = countNodes(node.left);
            int rightCount = countNodes(node.right);
            return 1 + leftCount + rightCount;
        }
    }

    public TreeNode<T> getRoot() {
        return root;
    }

}
