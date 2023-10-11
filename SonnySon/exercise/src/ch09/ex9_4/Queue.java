package ch09.ex9_4;

public class Queue<T> {
    ListNode head;
    ListNode tail;
    class ListNode{
        T item;
        ListNode next;
        ListNode(T item){this.item = item;}
    }

    public void enqueue(T newItem){

        ListNode newNode = new ListNode(newItem);

        if(this.head == null){
            this.head = newNode;
            this.tail = newNode;
            this.head.next = tail;
        }
        else{
            tail.next = newNode;
            tail = newNode;
        }
    }

    public T dequeue(){
        T popItem;
        if(this.head == null){
            throw new IllegalStateException("첫번째 요소가 없습니다.");
        }
        popItem = head.item;
        this.head = head.next;

        if(this.head == null){
            this.tail = null;
        }
        return popItem;
    }
    public boolean isEmpty(){
        return this.head == null;
    }
}
