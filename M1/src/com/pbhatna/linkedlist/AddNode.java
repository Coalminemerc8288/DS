package com.pbhatna.linkedlist;

/**
 * Append a new node to the end of the linked list.
 */
public class AddNode<T extends Comparable<T>> extends LinkedList {
    public void addNode1(T data) {
        if (head == null) {
            head = new Node<T>(data);
        } else {
            Node<T> curr = head;
            while (curr.getNext() != null) {
                curr = curr.getNext();
            }
            curr.setNext(new Node<T>(data));
        }
    }
}
