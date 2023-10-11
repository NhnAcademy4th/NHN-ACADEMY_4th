package com.nhnacademy.Chapter9.ex4;

import com.nhnacademy.Chapter9.ex2.TreeNode;

public class TreeQueue {

    private class Node {
        private TreeNode item;
        private Node next;
    }

    private static Node front = null;

    private static Node rear = null;

    public void insertQueue(TreeNode num) {
        Node node = new Node();
        node.item = num;
        if (front == null) {
            front = node;
            rear = node;
        } else {
            rear.next = node;
            rear = node;
        }
    }

    public TreeNode popQueue() {
        if (front == null) {
            throw new IllegalArgumentException("Empty Queue");
        }
        TreeNode frontItem = front.item;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return frontItem;
    }

    public boolean isEmpty() {
        return (front == null && rear == null);
    }
}
