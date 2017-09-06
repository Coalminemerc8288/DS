package com.pbhatna.linkedlist;

/**
 * Reverse all the nodes in the linked list so that the last node
 * becomes the first node.
 */
public class ReverseLinkedList<T extends Comparable<T>> extends LinkedList {
    public void reverseList() {
        if(head == null || head.getNext() == null) {
            return;
        }

        Node<T> prev = null;
        Node<T> curr = head;
        while (curr != null) {
            Node<T> next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }

        head = prev;
    }
}
