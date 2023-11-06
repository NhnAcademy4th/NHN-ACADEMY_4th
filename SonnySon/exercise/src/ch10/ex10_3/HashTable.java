package ch10.ex10_3;

import java.util.Objects;

public class HashTable {
    private Node[] hashTable = null;

    private int TABLESIZE;
    private int size;

    public HashTable(int tableSize){
        this.size = 0;
        this.TABLESIZE = tableSize;
        this.hashTable = new Node[tableSize];
    }

    private static class Node{
        String key;
        String item;
        Node next;
        Node previous = null;

        Node(String key, String item){
            this.key = key;
            this.item = item;
        }
        void setNext(Node next){
            this.next = next;
            next.previous = this;
        }
    }

    public void put(String key, String value){
        Node newNode = new Node(key, value);

        // Math.abs(newNode.hashCode()) % size 인경우 Math.abs(Integer.MAXVALUE) 인경우 리턴값이 Integer.MINVALUE인데 이값은 -1이다.
        int hash = Math.abs(key.hashCode() % TABLESIZE);

        // 해당 해쉬값의 배열이 비어있는경우
        if(Objects.isNull(hashTable[hash])) hashTable[hash] = newNode;

        // 배열에 이미 값이 있는경우
        else{
            Node runner = hashTable[hash];

            // 노드의 next에 추가
            while(Objects.isNull(runner.next)){

                // key 값 중복을 허용하지 않음
                if(runner.key.equals(key))
                    throw new IllegalArgumentException("Error : put() Method [Key duplicated]");
                runner = runner.next;
            }
            runner.setNext(newNode);
        }
        size++;
    }

    private String get(String key){
        int hash = Math.abs(key.hashCode() % TABLESIZE);
        if(Objects.isNull(hashTable[hash])){
            // 중복 해쉬값이 없는경우 예외
            return null;
        }
        else{
            Node runner = hashTable[hash];
            while(Objects.nonNull(runner)){
                if(runner.key.equals(key)) return runner.item;
                runner = runner.next;
            }
            // 중복 해쉬값이 있는경우 예외
            throw new IllegalArgumentException("Error : get() Method [Key isn't exist]");
        }
    }

    private void remove(String key){
        int hash = Math.abs(key.hashCode() % TABLESIZE);
        if(Objects.isNull(hashTable[hash])){
            throw new IllegalArgumentException("Error : remove() Method [Key isn't exist]");
        }
        else{
            Node runner = hashTable[hash];
            while(!Objects.isNull(runner)){
                if(runner.key.equals(key)){
                    // 해쉬값 중복이 없는경우
                    if(Objects.isNull(runner.previous)) hashTable[hash] = null;
                    // 해쉬값 중복이 있는경우
                    else runner.previous.setNext(runner.next);

                    size--;
                    return;
                }
                runner = runner.next;
            }
            throw new IllegalArgumentException("Error : remove() Method [Key isn't exist]");
        }
    }

    private boolean containKey(String key){
        int hash = Math.abs(key.hashCode() % TABLESIZE);
        if(Objects.isNull(hashTable[hash])) return false;
        else{
            Node runner = hashTable[hash];
            while(!Objects.isNull(runner)){
                if(runner.key.equals(key)) return true;
                runner = runner.next;
            }
            return false;
        }
    }

    private int size(){
        return size;
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable(100);
        hashTable.put("재훈","민수");
        hashTable.get("민수");

    }
}
