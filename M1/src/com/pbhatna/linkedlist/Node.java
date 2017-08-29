package com.pbhatna.linkedlist;

/**
 * Node
 */
public class Node<T> {

    private T data;
    private Node<T> next;

    public Node() {}

    public Node(T data) {
        this.data = data;
        setNext(null);
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
