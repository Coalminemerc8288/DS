package com.pbhatna.problems.linkedlist;

/**
 * Given a singly linked list L: L0→L1→ ... →Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→...
 * For example, given {1,2,3,4}, reorder it to {1,4,2,3}.
 * You must do this in-place without altering the nodes' values.
 *
 * Soln:
 * 1) Split the list in two half using fast and slow pointers
 * 2) Merge them back together
 *
 */
public class ReOrderLinkedList<T extends Comparable<T>> extends LinkedList {

    public static void getReorderedList(Node<Integer> head) {
        if (head == null && head.getNext() == null) {
            return;
        }

        Node<Integer> slow = head;
        Node<Integer> fast = head;

        while (fast != null && fast.getNext() != null && fast.getNext().getNext() != null) {
            slow  = slow.getNext();
            fast =  fast.getNext().getNext();
        }

        // Splitted two lists
        Node<Integer> first = slow.getNext();
        Node<Integer> second = fast.getNext();
        second.setNext(null);

        // Reverse the second list
        second = getReverse(second);
        printNodes(second);

        // Merge list back together
        Node<Integer> p1 = first.getNext();
        Node<Integer> p2 = second.getNext();

        while (p1!= null || p2 != null) {
            Node<Integer> temp1 = p1.getNext();
            Node<Integer> temp2 = p2.getNext();

            p1.setNext(p2);
            p2.setNext(temp1);
            p1 = temp1;
            p2 = temp2;

        }
    }

    public static Node<Integer> getReverse(Node<Integer> head) {
        if (head == null || head.getNext() == null) {
            return head;
        }

        Node<Integer> second = head.getNext();
        second.setNext(null);

        Node<Integer> result = getReverse(second);
        second.setNext(head);

        return result;
    }

}
