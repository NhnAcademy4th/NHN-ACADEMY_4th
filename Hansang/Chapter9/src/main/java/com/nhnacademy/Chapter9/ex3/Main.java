package com.nhnacademy.Chapter9.ex3;

public class Main {
    public static void main(String[] args) {

        int[] test = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for (int j : test) {
            ListNode.insertList(j);
        }
        ListNode.showList(ListNode.getHeadNode());
        ListNode duplicate = ListNode.reverseLinkedList(ListNode.getHeadNode());
        System.out.println();
        ListNode.showList(duplicate);

    }
}
