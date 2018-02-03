package com.pbhatna.linkedlist;
/**
 * Solution: Use two pointers, fast forward one and move ahead n by another
 */
public class RemoveNthNodeFromEnd {

    public Node<Integer> removeNthNodeFromEnd(Node<Integer> head, int n) {
        if (head == null || head.getNext() == null) {
            return head;
        }

        Node<Integer> slow = head;
        Node<Integer> start = slow;
        Node<Integer> fast = head;

        //move the pointer n+1 ahead
        int i=0;
        while (i < n + 1) {
            fast = fast.getNext();
            i++;
        }

        // iterate
        while (fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext();
        }
        slow.setNext(slow.getNext().getNext());

        return start;
    }
}
