package com.pbhatna.linkedlist;

/**
 * Complex:(Incomplete) Trying to do in in place operation
 *
 * Input : 1 -> -2 -> -3 -> 4 -> -5
 * output: -5 -> -3 -> -2 -> 1 -> 4
 */
public class SortLinkedList <T extends Comparable<T>> extends LinkedList {

    public Node<T> sortListOnActual(Node<T> head) {
        if (head == null) {
            return new Node<T>(null);
        }

        Node<T> curr = head;
        Node<T> prev = null;

        Node<T> p1 = head;
        Node<T> p2 = head;

        while (curr.getNext() != null) {
            prev = curr;
            curr = curr.getNext();
            if ((Integer) curr.getData() < 0) {
               if (curr.getData().compareTo(head.getData()) == -1) {
                   Node<T> temp = p1.getNext();
                   curr.setNext(temp);
                   p1.setNext(curr);
               } else {
                 Node<T> temp = p2.getNext();
                 curr.setNext(temp);
               }
            } else {

            }

        }
        return head;
    }
}