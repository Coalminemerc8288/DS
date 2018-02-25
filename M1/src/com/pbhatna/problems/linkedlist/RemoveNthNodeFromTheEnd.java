package com.pbhatna.problems.linkedlist;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 * For example, given linked list 1->2->3->4->5 and n = 2, the result is 1->2->3->5.
 */
public class RemoveNthNodeFromTheEnd {

    public Node<Integer> removeNthNode(Node<Integer> head, int n) {
        if (head == null || head.getNext() == null) {
            return head;
        }

        Node<Integer> slow = head;
        Node<Integer> fast = head;

        //Move fast pointer n step ahead
        int i = 0;
        while (i < n) {
            fast = fast.getNext();
            i++;
        }

        while (fast!= null) {
            slow = slow.getNext();
            fast = fast.getNext();
        }

        slow.setNext(slow.getNext().getNext());

        return head;
    }
}
