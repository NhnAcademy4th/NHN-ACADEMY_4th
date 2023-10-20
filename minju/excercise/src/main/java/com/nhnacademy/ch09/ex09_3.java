package com.nhnacademy.ch09;

import java.util.Random;

public class ex09_3 {
    public static void main(String[] args) {
        printNodes();
    }

    private static void printNodes() {
        ListNode<Integer> head = testList();
        System.out.print("List : ");
        head.printList();
        System.out.print("\n Reverse : ");
        head.printReverse();
    }

    private static ListNode<Integer> testList() {
        Random random = new Random();
        ListNode<Integer> head = new ListNode<>(random.nextInt(100));
        for (int i = 0; i < 5; i++) {
            head.insertListNode(random.nextInt(100));
        }
        return head;
    }
}