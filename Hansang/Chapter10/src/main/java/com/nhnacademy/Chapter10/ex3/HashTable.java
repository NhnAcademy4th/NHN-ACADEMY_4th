package com.nhnacademy.Chapter10.ex3;

public class HashTable {
    private static class Node {
        private String key;
        private String value;
        Node next;
    }

    private static Node[] data;
    private static int count;

    public HashTable(int initSize) {
        if (data == null) {
            data = new Node[initSize];
        }
    }

    public void put(String key, String value) throws IllegalAccessException {
        if (key == null) {
            throw new IllegalAccessException("key is null!");
        }

        Node node = data[hash(key)];

        while (node != null) {
            if (node.key.equals(key)) {
                node.value = value;
                break;
            }
            node = node.next;
        }

        Node newNode = new Node();
        newNode.key = key;
        newNode.value = value;
        newNode.next = data[hash(key)];
        data[hash(key)] = newNode;
        count++;
    }

    public int size() {
        return count;
    }

    public String get(String key) throws IllegalAccessException {
        if (key == null) {
            throw new IllegalAccessException("Key can not null");
        }

        Node node = data[hash(key)];
        if (node == null) {
            throw new IllegalAccessException("You can not find value with this key!");
        }

        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    private int hash(String key) {
        return Math.abs(key.hashCode()) % data.length;
    }

    public void remove(String key) throws IllegalAccessException {
        if (key == null) {
            throw new IllegalAccessException("Key can not null");
        }

        if (data[hash(key)] == null) {
            throw new IllegalAccessException("You can not remove value with this key!");
        }


        if (data[hash(key)].key.equals(key)) {
            data[hash(key)] = data[hash(key)].next;
            count--;
            return;
        }

        Node prev = data[hash(key)];

        Node cur = prev.next;

        while (cur != null && !cur.key.equals(key)) {
            cur = cur.next;
            prev = cur;
        }

        if (cur != null) {
            prev.next = cur.next;
            count--;
        }

    }


}
