package com.pbhatna.linkedlist;

/**
 * Insert the data into the correct position in a sorted list. Assume
 * that the list is sorted in ascending order.
 */
public class InsertIntoSortedList<T extends Comparable<T>> extends LinkedList {

    public void InsertIntoSortedList(T data) {
        if (countNodes() == 0 || head.getData().compareTo(data) > 0) {
            Node<T> next = head;
            head = new Node<T>(data);
            head.setNext(next);
        }
        else {
            Node<T> curr = head;
            while (curr.getNext() != null && curr.getNext().getData().compareTo(data) < 0) {
                curr = curr.getNext();
            }
            Node<T> next = curr.getNext();
            curr.setNext(new Node<T>(data));
            curr.getNext().setNext(next);
        }
    }
}
