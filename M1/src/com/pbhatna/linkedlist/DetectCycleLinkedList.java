package com.pbhatna.linkedlist;

/**
 * If lincked list has cycles
 */
public class DetectCycleLinkedList extends LinkedList {

    public static boolean hasCycle(Node<Integer> head) {
        if (head == null || head.getNext() == null) {
            return false;
        }

        Node<Integer> slow = head;
        Node<Integer> fast = head;

        while (fast != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
