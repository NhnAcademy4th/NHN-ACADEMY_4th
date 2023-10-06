import java.util.Objects;

public class TreeQueue<T> {
    ListNode<TreeNode<T>> head;

    public TreeQueue(TreeNode<T> root) {
        head = new ListNode<>(root);
    }

    public void push(TreeNode<T> item) {
        if (Objects.isNull(item))
            return;
        head.insertListNode(item);
    }

    public TreeNode<T> pop() {
        TreeNode<T> item = head.getItem();
        head = head.next;
        return item;
    }

    public void printTreeQueue() {
        while (!isEmpty()) {
            push(head.getItem().left);
            push(head.getItem().right);
            System.out.print(pop().getItem() + " ");
        }
    }

    public boolean isEmpty() {
        return Objects.isNull(head);
    }

}
