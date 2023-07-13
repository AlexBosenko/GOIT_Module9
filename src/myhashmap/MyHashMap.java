package myhashmap;

import java.util.LinkedList;
import java.util.List;
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
        resizeData();

        int index = hash(key);
        if (hashTable[index] == null) {
            addFirst(key, value, index);
        } else {
            List<Node<K, V>> nodeList = hashTable[index].nodes;
            boolean needAdd = true;
            for (Node<K, V> node : nodeList) {
                if (hash(node.key) == hash(key)) {
                    if (Objects.equals(node.key, key)) {
                        needAdd = false;
                        if (!Objects.equals(node.value, value)) {
                            node.value = value;
                        }
                    }
                }
            }

            if (needAdd) {
                nodeList.add(new Node<>(key, value));
                size++;
            }
        }
    }

    public void remove(K key) {
        int index = hash(key);

        if (index < hashTable.length && hashTable[index] != null) {
            Node<K, V> target = null;
            List<Node<K, V>> nodeList = hashTable[index].nodes;
            for (Node<K, V> node : nodeList) {
                if (Objects.equals(node.key, key)) {
                    target = node;
                }
            }
            if (target != null) {
                nodeList.remove(target);
                size--;
            }
        }
    }

    public V get(K key) {
        V result = null;
        int index = hash(key);

        if (index < hashTable.length && hashTable[index] != null) {
            Node<K, V> target = null;
            List<Node<K, V>> nodeList = hashTable[index].nodes;
            for (Node<K, V> node : nodeList) {
                if (Objects.equals(node.key, key)) {
                    result = node.value;
                }
            }
        }

        return result;
    }

    public void clear() {
        hashTable = new Node[capacity];
        size = 0;
    }

    private void addFirst(K key, V value, int index) {
        hashTable[index] = new Node<K, V>(null, null);
        hashTable[index].nodes.add(new Node<>(key, value));

        size++;
    }

    private void resizeData() {
        float boundarySize = size + size * 0.25f;

        if (boundarySize > hashTable.length) {
            Node<K, V>[] oldHashTable = hashTable;
            hashTable = new Node[hashTable.length * 2];
            for (Node<K, V> node : oldHashTable) {
                if (node != null) {
                    for (Node<K, V> n : node.nodes) {
                        put(n.key, n.value);
                    }
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

        return Math.abs(key.hashCode() % capacity);
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ");
        for (Node<K, V> node : hashTable) {
            if (node != null) {
                for (Node<K, V> n : node.nodes) {
                    joiner.add(GetKeyValueAsString(n.key, n.value));
                }
            }
        }

        return "{" + joiner + "}";
    }

    private String GetKeyValueAsString(K key, V value) {
        return key.toString() +
                "=" +
                value.toString();
    }

    private class Node<K, V> {
        private K key;
        private V value;
        private List<Node<K, V>> nodes;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.nodes = new LinkedList<Node<K, V>>();
        }
    }

}
