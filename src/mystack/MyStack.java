package mystack;

import java.util.StringJoiner;

public class MyStack<E> {
    private Node<E> fstNode;
    private Node<E> lstNode;
    private int size;

    public MyStack() {
    }
    public void push(E value) {
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
        fstNode = null;
        lstNode = null;
        size = 0;
    }
    public int size() {
        return size;
    }
    public E peek() {
        if (fstNode == null) {
            return null;
        }
        return fstNode.currElement;
    }
    public E poll() {
        Node<E> removed = fstNode;
        if (removed == null) {
            return null;
        } else {
            E element = fstNode.currElement;
            detach(fstNode);
            return element;
        }
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

    private E get(int index) {
        checkIndex(index);
        return node(index).currElement;
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
            joiner.add(element.toString());
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
