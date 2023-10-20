package com.nhnacademy.ch09;

import java.util.Objects;

public class ListNode<T> {

    private T item;
    protected ListNode<T> next;

    public ListNode(T item) {
        this.item = item;
    }

    public void insertListNode(T newItem) {
        if (!Objects.isNull(this.next)) {
            this.next.insertListNode(newItem);
        } else {
            this.next = new ListNode<>(newItem);
        }
    }

    public void printList() {
        System.out.print(this.item + " ");
        if (!Objects.isNull(this.next))
            this.next.printList();
    }

    public void printReverse() {
        if (!Objects.isNull(this.next))
            this.next.printReverse();
        System.out.print(this.item + " ");
    }

    public T getItem() {
        return item;
    }
}
