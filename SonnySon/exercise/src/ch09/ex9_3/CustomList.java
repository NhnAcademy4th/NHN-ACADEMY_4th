package ch09.ex9_3;

public class CustomList<T>{
    private ListNode root;
    class ListNode {

        T item;
        ListNode next;
        ListNode(T item){this.item = item;}

    }

    public void insert(T newItem){
        if(root == null){
            root = new ListNode(newItem);

        }else{
            ListNode runner = root;

            while(true){
                if(runner.next == null){
                    runner.next = new ListNode(newItem);
                    break;
                }
                else
                    runner = runner.next;
            }
        }

    }
    public void showList(){
        showList(root);
    }

    public void showReversedList(){
        showList(reverseList());
    }

    public void showList(ListNode runner){
        System.out.print("{");
        while(runner != null){
            System.out.print(runner.item+" ");
            runner = runner.next;
        }
        System.out.print("}");
        System.out.println();

    }

    public ListNode reverseList(){
        ListNode rev = null;
        ListNode runner = root;
        while(runner != null){
            ListNode newNode = new ListNode(runner.item);
            newNode.next = rev;
            rev = newNode;
            runner = runner.next;
        }
        return rev;
    }
}
