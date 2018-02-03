package com.pbhatna.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * Write a removeDuplicates() function which takes a list and deletes any duplicate nodes from the list. The list is not sorted.
 * For example if the linked list is 12->11->12->21->41->43->21 then removeDuplicates() should convert the list to 12->11->21->41->43.
 */
public class RemoveDuplicatesInUnsortedList extends LinkedList {

    public static Node<Integer> removeDuplicatesInUnsorted(Node<Integer> head) {
        if (head == null) {
            return new Node<>(0);
        }

        Node<Integer> curr = head;
        Node<Integer> prev = null;
        Set<Integer> hashSet = new HashSet<>();

        while(curr != null) {
            if (curr != null  && curr.getNext() != null) {
                if (curr.getData() == curr.getNext().getData()) {
                    curr.setNext(curr.getNext().getNext());
                }
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

    public static void main(String []args) {

        LinkedList<Integer> l1 = new LinkedList<java.lang.Integer>();
        System.out.println(l1);
        l1.addNode(12);
        l1.addNode(11);
        l1.addNode(12);
        l1.addNode(21);
        l1.addNode(41);
        l1.addNode(43);
        l1.addNode(21);
        l1.addNode(43);
        l1.addNode(21);
        l1.addNode(21);



        System.out.println("Original Linked List");
        printNodes(l1.getHead());

        System.out.println("Without Duplicates");
        Node<Integer> l2 = removeDuplicatesInUnsorted(l1.getHead());
        printNodes(l2);
    }
}
