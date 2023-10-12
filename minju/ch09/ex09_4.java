public class ex09_4 {
    public static void main(String[] args) {
        testTreeQueue();
    }

    private static void testTreeQueue() {
        SortTree<String> sortTree = new SortTree<>();
        sortTree.insert("가");
        sortTree.insert("나");
        sortTree.insert("다");
        sortTree.insert("라");
        sortTree.insert("마");
        new TreeQueue<>(sortTree.getRoot()).printTreeQueue();
    }
}
