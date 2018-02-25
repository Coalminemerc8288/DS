package com.pbhatna.linkedlist;

/**
 * Insert at the nth position in the list. Return if the number of nodes is
 * less than n.
 */
public class InsertAtNthNode <T extends Comparable<T>> extends LinkedList {

    public void insertAtNthNode(int n, T data) {
        if (n > countNodes()) {
            return;
        }

        if (n == 0) {
            // To insert at the 0th position update the head itself.
            Node<T> nextNode = head;
            head = new Node<>(data);
            head.setNext(nextNode);
        } else {
            // Move the curr node to one before the position where we
            // want to insert the element and adjust the pointers accordingly.
            int i = 0;
            Node<T> curr = head;
            while (i < n - 1) {
                curr = curr.getNext();
                i++;
            }
            Node<T> next = curr.getNext();

            curr.setNext(new Node<T>(data));
            curr.getNext().setNext(next);
        }
    }
}
