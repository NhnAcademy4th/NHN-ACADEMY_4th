import java.util.Random;

public class ex09_3 {
    public static void main(String[] args) {
        testList();
    }

    public static void testList() {
        Random random = new Random();
        ListNode<Integer> head = new ListNode<>(random.nextInt(100));
        for (int i = 0; i < 5; i++) {
            head.insertListNode(random.nextInt(100));
        }

        System.out.print("List : ");
        head.printList();
        System.out.println();
        System.out.print("Reverse : ");
        head.printReverse();
    }
}