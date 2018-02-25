package com.pbhatna.problems.linkedlist;

/**
 * Doubly Linked List Node
 */
public class DbNode<T extends Comparable<T>> {
    private T data;
    private DbNode<T> next;
    private DbNode<T> prev;

    public DbNode(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public DbNode(T data, DbNode<T> next, DbNode<T> prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    public DbNode<T> getNext() {
        return next;
    }

    public void setNext(DbNode<T> next) {
        this.next = next;
    }

    public DbNode<T> getPrev() {
        return prev;
    }

    public void setPrev(DbNode<T> prev) {
        this.prev = prev;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
