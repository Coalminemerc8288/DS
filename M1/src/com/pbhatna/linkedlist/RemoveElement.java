package com.pbhatna.linkedlist;

/**
 * Return the first element in the linked list.
 */
public class RemoveElement <T extends Comparable<T>> extends LinkedList  {

    public T popElement() {
        if (head != null) {

            T topElement = (T) head.getData();
            head = head.getNext();
            return topElement;
        }
        return null;
    }
}
