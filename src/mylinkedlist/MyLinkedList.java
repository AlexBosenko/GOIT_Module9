package mylinkedlist;

import java.util.StringJoiner;

public class MyLinkedList<E> {
    private Node<E> fstNode;
    private Node<E> lstNode;
    private int size;

    public MyLinkedList() {
    }

    public void add(E value) {
        Node<E> prev = lstNode;
        Node<E> newNode = new Node<>(value, prev, null);
        lstNode = newNode;
        if (prev == null) {
            fstNode = newNode;
        } else {
            prev.nextElement =lstNode;
        }
        size++;
    }
    public void remove(int index) {
        checkIndex(index);
        detach(node(index));
    }
    public void clear() {
        Node<E> curr = fstNode;
        while (curr != null) {
            Node<E> next = curr.nextElement;
            curr.currElement = null;
            curr.prevElement = null;
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
    public E get(int index) {
        checkIndex(index);
        return node(index).currElement;
    }

    private Node<E> node(int index) {
        Node<E> target = fstNode;
        for (int i = 0; i < index; i++) {
            target = target.nextElement;
        }
        return target;
    }
    private void detach(Node<E> node) {
        E curr = node.currElement;
        Node<E> prev = node.prevElement;
        Node<E> next = node.nextElement;

        if (prev == null) {
            fstNode = next;
        } else {
            prev.nextElement = next;
            node.prevElement = null;
        }

        if (next == null) {
            lstNode = prev;
        } else {
            next.prevElement = prev;
            node.nextElement = null;
        }

        node.currElement = null;

        size--;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public String toString() {
        E element;
        StringJoiner joiner = new StringJoiner(", ");

        for (int i = 0; i < size; i++) {
            element = get(i);
            joiner.add(String.valueOf(element));
        }
        return "[" + joiner + "]";
    }

    private class Node<E> {
        E currElement;
        Node<E> prevElement;
        Node<E> nextElement;

        public Node(E currElement, Node<E> prevElement, Node<E> nextElement) {
            this.currElement = currElement;
            this.prevElement = prevElement;
            this.nextElement = nextElement;
        }

    }
}
