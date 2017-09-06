package com.pbhatna.linkedlist;
import java.util.*;

/**
 * Write a removeDuplicates() function which takes a list and deletes any duplicate nodes from the list. The list is not sorted.
 * For example if the linked list is 12->11->12->21->41->43->21 then removeDuplicates() should convert the list to 12->11->21->41->43.
 */
public class RemoveDuplicatesInUnsortedList<T extends Comparable<T>> extends LinkedList {

    public Node<T> removeDuplicatesInUnsorted(Node<T> head) {
        if (head == null) {
            return new Node<T>(null);
        }
        Node<T> curr = head;
        Node<T> prev = null;

        Set<T> hashSet = new HashSet<>();
        while(curr.getNext() != null) {
            if (curr.getData() == curr.getNext().getData()) {
                curr.setNext(curr.getNext().getNext());
            }

            if (hashSet.contains(curr.getData())) {
                prev.setNext(curr.getNext());
            } else {
                hashSet.add(curr.getData());
                prev = curr;
            }
            curr = curr.getNext();
        }
        return head;
    }
}
