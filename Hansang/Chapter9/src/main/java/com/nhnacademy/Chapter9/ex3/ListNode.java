package com.nhnacademy.Chapter9.ex3;

public class ListNode {
    int item;
    ListNode next;

    public ListNode(int item) {
        this.item = item;
    }

    private static ListNode headNode;

    public static ListNode getHeadNode() {
        return headNode;
    }

    public static void insertList(int number) {
        if (headNode == null) {
            headNode = new ListNode(number);
            return;
        }
        ListNode node = headNode;
        while (true) {
            if (node.next == null) {
                node.next = new ListNode(number);
                return;
            }
            node = node.next;
        }
    }

    public static ListNode reverseLinkedList(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode duplicate = reverseLinkedList(node.next);
        node.next.next = node;
        node.next = null;
        return duplicate;
    }

    public static void showList(ListNode node) {
        if (node != null) {
            System.out.println(node.item);
            showList(node.next);
        }

    }
}
