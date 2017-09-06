package com.pbhatna.linkedlist;

/**
 * Append the nodes of the other list to the end of the curren list.
 */
public class AppendListToCurrList  <T extends Comparable<T>> extends LinkedList{

    public void appendList(LinkedList<T> ll) {
        if (ll.head == null) {
            return;
        } else {
            Node<T> curr = ll.head;
            while (curr != null) {
                addNode((T) curr.getData());
                curr = curr.getNext();
            }
        }
    }
}
