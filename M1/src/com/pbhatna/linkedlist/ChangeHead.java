package com.pbhatna.linkedlist;

/**
 * Move the head element or the first element from this list to
 * the destination linked list as the destination's new head node.
 */
public class ChangeHead <T extends Comparable<T>> extends LinkedList {

    public void changeHead(LinkedList<T> destinationList) {
        T currHead = (T) popElement();
        if (destinationList.head == null) {
            // If this is the first element in the destination list , simply
            // add it to the list.
            destinationList.addNode(currHead);
        } else {
            Node<T> next = destinationList.head;
            destinationList.head = new Node<T>(currHead);
            destinationList.head.setNext(next);
        }
    }
}
