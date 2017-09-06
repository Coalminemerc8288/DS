package com.pbhatna.stacks;

/**
 * LinkedList Node for stack Implementation
 */
public class Element<T extends Comparable<T>> {

    private T data;
    private Element next;

    Element(T data, Element next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Element getNext() {
        return next;
    }

    public void setNext(Element next) {
        this.next = next;
    }

}
