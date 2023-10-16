package ex10_3;

import java.util.Objects;

public class StringHashtable {

    private static class ListNode {
        String key;
        String value;
        ListNode next;

        ListNode(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private ListNode[] table;
    private int count;

    public StringHashtable(int size) {
        if (size < 1) {
            throw new IllegalArgumentException("크기는 1보다 작을 수 없습니다.");
        }
        count = 0;
        table = new ListNode[size];
    }

    public void put(String key, String value) {
        if (Objects.isNull(key))
            throw new IllegalArgumentException("key 값은 Null 일 수 없습니다.");

        if (containsKey(key))
            throw new IllegalArgumentException("key 값이 존재합니다.");

        ListNode node = new ListNode(key, value);
        node.next = table[hash(key)];
        table[hash(key)] = node;
        count++;
    }

    public void remove(String key) {
        ListNode node = table[hash(key)];

        if (Objects.isNull(node))
            throw new IllegalArgumentException("존재하지 않는 key 값입니다.");

        if (node.key.equals(key)) {
            table[hash(key)] = null;
            count--;
            return;
        }

        ListNode previous = node;
        while (!Objects.isNull(node)) {
            if (node.key.equals(key)) {
                previous.next = node.next;
                count--;
                return;
            }
            previous = node;
            node = node.next;
        }
        throw new IllegalArgumentException("존재하지 않는 key 값입니다.");
    }

    public String get(String key) {
        ListNode node = table[hash(key)];
        while (Objects.nonNull(node)) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }
        throw new IllegalArgumentException("존재하지 않는 key 값입니다.");
    }

    public boolean containsKey(String key) {
        ListNode node = table[hash(key)];
        while (Objects.nonNull(node)) {
            if (node.key.equals(key)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public int size() {
        return count;
    }

    private int hash(String key) {
        return Math.abs(key.hashCode()) % table.length;
    }

}
