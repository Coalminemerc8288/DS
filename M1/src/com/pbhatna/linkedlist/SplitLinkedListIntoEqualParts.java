package com.pbhatna.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * Split a linked list into 2 equal parts. If there are an odd number of
 * elements, the extra element should be in the first list.
 */
public class SplitLinkedListIntoEqualParts <T extends Comparable<T>> extends LinkedList {

    public List<Node<T>> frontBackSplit() {
        Node<T> front = null;
        Node<T> back = null;

        // A 0 element list means both the front list and back
        // list will both be null.
        if (head == null) {
            front = null;
            back = null;
        } else if (head.getNext() == null) {
            // For a one element list, include the first element in the
            // front list.
            front = head;
            back = null;
        } else {
            // Move one pointer twice as fast as another.
            Node<T> slow = head;
            Node<T> fast = head;

            while (fast != null) {
                fast = fast.getNext();
                if (fast == null) {
                    break;
                }
                fast = fast.getNext();
                if (fast != null) {
                    slow = slow.getNext();
                }
            }
            front = head;
            back = slow.getNext();
            slow.setNext(null);
        }

        List<Node<T>> list = new ArrayList<>();
        list.add(front);
        list.add(back);

        return list;
    }
}
