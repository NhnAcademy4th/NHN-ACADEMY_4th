package course2.chapter9.ex9_2;

public class BinarySortTree {
    private Node rootNode = null;

    public void insert(String element) {
        if (this.rootNode == null) {
            this.rootNode = new Node(element);
        } else {
            this.rootNode = findLeafNode(this.rootNode, new Node(element));
        }
    }

    private Node findLeafNode(Node node, Node newNode) {
        if (node == null) {
            return newNode;
        } else if (node.value.compareTo(newNode.value)>0) {
            node.leftChild = findLeafNode(node.leftChild, newNode);
        } else {
            node.rightChild = findLeafNode(node.rightChild, newNode);
        }
        return node;
    }

    public String inorderTree() {
        StringBuilder sb = new StringBuilder();
        recursionForInorder(sb, this.rootNode);
        return sb.toString();
    }

    private void recursionForInorder(StringBuilder sb, Node node) {
        if (node != null) {
            recursionForInorder(sb, node.leftChild);
            sb.append(node.value+"\r\n");
            recursionForInorder(sb, node.rightChild);
        }
    }
}
