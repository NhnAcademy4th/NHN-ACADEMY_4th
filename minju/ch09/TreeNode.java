public class TreeNode<T> {

    private T item;
    TreeNode<T> left;
    TreeNode<T> right;

    public TreeNode(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }
}
