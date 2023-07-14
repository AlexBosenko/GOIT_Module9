package myhashmap;

import java.util.Objects;
import java.util.StringJoiner;

public class MyHashMap<K, V> {
    private final int capacity = 16;
    private Node<K, V>[] hashTable;
    private int size = 0;

    public MyHashMap() {
        this.hashTable = new Node[capacity];
    }

    public void put(K key, V value) {
        if (size == hashTable.length) {
            resizeData();
        }

        putValue(key, value);
        size++;
    }

    private void putValue(K key, V value) {
        int index = hash(key);
        if (hashTable[index] == null) {
            addFirst(key, value, index);
        } else {
            Node<K, V> fstNode = hashTable[index];
            Node<K, V> lstNode = fstNode;
            boolean needAdd = true;
            for (Node<K, V> curr = fstNode; curr != null;) {
                if (hash(curr.key) == hash(key)) {
                    if (Objects.equals(curr.key, key)) {
                        needAdd = false;
                        if (!Objects.equals(curr.value, value)) {
                            curr.value = value;
                        }
                    }
                }
                lstNode = curr;
                curr = curr.nextElement;
            }

            if (needAdd) {
                lstNode.nextElement = new Node<>(key, value, null);
            }
        }
    }

    public void remove(K key) {
        int index = hash(key);

        if (index < hashTable.length && hashTable[index] != null) {
            Node<K, V> fstNode = hashTable[index];
            Node<K, V> prev = fstNode;
            for (Node<K, V> curr = fstNode; curr != null;) {
                if (Objects.equals(curr.key, key)) {
                    if (Objects.equals(curr, fstNode)) {
                        hashTable[index] = curr.nextElement;
                    }
                    if (!Objects.equals(curr, prev)) {
                        prev.nextElement = (curr.nextElement == null) ? null : curr.nextElement;
                    }
                    clearNode(curr);
                    size--;
                }
                prev = curr;
                curr = curr.nextElement;
            }
        }
    }

    private void clearNode(Node<K,V> curr) {
        curr.key = null;
        curr.value = null;
        curr.nextElement = null;
    }

    public V get(K key) {
        V result = null;
        int index = hash(key);

        if (index < hashTable.length && hashTable[index] != null) {
            Node<K, V> target = null;
            Node<K, V> fstNode = hashTable[index];
            for (Node<K, V> curr = fstNode; curr != null;) {
                if (Objects.equals(curr.key, key)) {
                    result = curr.value;
                }
                curr = curr.nextElement;
            }
        }

        return result;
    }

    public void clear() {
        hashTable = new Node[capacity];
        size = 0;
    }

    private void addFirst(K key, V value, int index) {
        hashTable[index] = new Node<K, V>(key, value, null);
    }

    private void resizeData() {
        Node<K, V>[] oldHashTable = hashTable;
        hashTable = new Node[oldHashTable.length * 2];
        for (Node<K, V> node : oldHashTable) {
            if (node != null) {
                for (Node<K, V> curr = node; curr != null;) {
                    putValue(curr.key, curr.value);
                    curr = curr.nextElement;
                }
            }
        }
    }

    public int size() {
        return size;
    }

    public int getHash(K key) {
        return hash(key);
    }

    private int hash(K key) {
        if (key == null) {
            return 0;
        }

        return Math.abs(key.hashCode() % hashTable.length);
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ");

        for (Node<K, V> node : hashTable) {
            if (node != null) {
                for (Node<K, V> curr = node; curr != null;) {
                    joiner.add(getKeyValueAsString(curr.key, curr.value));
                    curr = curr.nextElement;
                }
            }
        }

        return "{" + joiner + "}";
    }

    private String getKeyValueAsString(K key, V value) {
        return key.toString() +
                "=" +
                value.toString();
    }

    private class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> nextElement;

        public Node(K key, V value, Node<K, V> nextElement) {
            this.key = key;
            this.value = value;
            this.nextElement = nextElement;
        }
    }

}
