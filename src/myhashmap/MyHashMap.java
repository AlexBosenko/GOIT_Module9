package myhashmap;

import java.util.StringJoiner;

public class MyHashMap<K, V> {
    private Node<K, V> fstNode;
    private Node<K, V> lstNode;
    private int size;

    public MyHashMap() {
    }
    public void put(K key, V value) {
        if (!keyExists(key, value)) {
            Node<K, V> lst = lstNode;
            Node<K, V> newNode = new Node<>(key, value, null);
            lstNode = newNode;
            if (fstNode == null) {
                fstNode = newNode;
            }
            if (lst != null) {
                lst.nextElement = newNode;
            }
            size++;
        }
    }

    private boolean keyExists(K key, V value) {
        for (Node<K, V> curr = fstNode; curr != null; ) {
            if (curr.key.equals(key)) {
                curr.value = value;
                return true;
            }
            curr = curr.nextElement;
        }
        return false;
    }

    public void remove(K key) {
        Node<K, V> curr = fstNode;
        Node<K, V> prev = fstNode;
        while (curr != null) {
            if (curr.key.equals(key)) {
                if (!curr.equals(prev)) {
                    prev.nextElement = (curr.nextElement == null) ? null : curr.nextElement;
                }
                clearNode(curr);
                size--;
            }
            prev = curr;
            curr = curr.nextElement;
        }
    }
    public void clear() {
        Node<K, V> curr = fstNode;
        while (curr != null) {
            Node<K, V> next = curr.nextElement;
            curr.key = null;
            curr.value = null;
            curr.nextElement = null;
            curr = next;
        }

        fstNode = null;
        lstNode = null;
        size = 0;
    }
    public int size() {
        return size;
    }
    public V get(K key) {
        if (fstNode == null) {
            return  null;
        }
        for (Node<K, V> curr = fstNode; curr != null;) {
            if (curr.key.equals(key)) {
                return curr.value;
            }
            curr = curr.nextElement;
        }

        return null;
    }

    private void clearNode(Node<K, V> curr) {
        curr.nextElement = null;
        curr.key = null;
        curr.value = null;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ");
        for (Node<K, V> curr = fstNode; curr != null;) {
            joiner.add(GetKeyValueAsString(curr.key, curr.value));
            curr = curr.nextElement;
        }
        return "[" + joiner + "]";
    }

    private String GetKeyValueAsString(K key, V value) {
        return "{" +
                key.toString() +
                " : " +
                value.toString() +
                "}";
    }

    private class Node<K, V> {
        K key;
        V value;
        Node<K, V> nextElement;

        public Node(K key, V value, Node<K, V> nextElement) {
            this.key = key;
            this.value = value;
            this.nextElement = nextElement;
        }
    }
}

