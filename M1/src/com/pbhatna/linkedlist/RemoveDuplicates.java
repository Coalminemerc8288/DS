package com.pbhatna.linkedlist;

/**
 * Write a removeDuplicates() function which takes a list sorted in non-decreasing order and deletes any duplicate nodes from the list.
 * The list should only be traversed once.
 * For example if the linked list is 11->11->11->21->43->43->60 then removeDuplicates() should convert the list to 11->21->43->60.
 */
public class RemoveDuplicates<T extends Comparable<T>> extends LinkedList {


    public Node<T> removeDuplicates(Node<T> head) {
        if (head == null) {
            return new Node<T>(null);
        }
        Node<T> curr = head;
        while(curr.getNext() != null) {
            if (curr.getData() == curr.getNext().getData()) {
//                System.out.println("4-------->"+ curr.getData() +": "+ curr.getNext().getData());

                curr.setNext(curr.getNext().getNext());
            }
            curr = curr.getNext();
        }
//        System.out.println("5-------->"+ curr.getData());
        return head;
    }
}
