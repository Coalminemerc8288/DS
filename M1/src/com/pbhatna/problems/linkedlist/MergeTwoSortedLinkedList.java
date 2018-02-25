package com.pbhatna.problems.linkedlist;

/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 */
public class MergeTwoSortedLinkedList extends LinkedList {

   public static Node<Integer> mergedSortedList(Node<Integer> l1, Node<Integer> l2) {
        Node<Integer> head = new Node<>(0);
        Node<Integer> result = head;

        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.getData() < l2.getData()) {
                    result.setNext(l1);
                    l1 = l1.getNext();
                } else {
                    result.setNext(l2);
                    l2 = l2.getNext();
                }
                result = result.getNext();
            } else if (l1 == null) {
                result.setNext(l2);
                break;
            } else if (l2 == null) {
                result.setNext(l1);
                break;
            }
        }
       return head.getNext();
   }
}
