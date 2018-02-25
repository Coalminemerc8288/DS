package com.pbhatna.problems.linkedlist;
/**
 * Given a sorted linked list,
 * delete all duplicates such that each element appear only once.
 *
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 */
public class RemoveDuplicates extends LinkedList {

    public static Node<Integer> removeDuplicates(Node<Integer> head) {
        if (head == null) {
            return new Node<>(0);
        }

        Node<Integer> curr = head;

        while(curr != null && curr.getNext() != null) {
            if (curr.getData() == curr.getNext().getData()) {
                curr.setNext(curr.getNext().getNext());
            } else {
                curr = curr.getNext();
            }
        }
        return head;
    }

    public static void main(String []args) {

        LinkedList<Integer> l1 = new LinkedList<Integer>();
        System.out.println(l1);
        l1.addNode(1);
        l1.addNode(1);
        l1.addNode(1);
        l1.addNode(1);
        l1.addNode(1);
        l1.addNode(2);
        l1.addNode(2);
        l1.addNode(2);
        l1.addNode(2);
        l1.addNode(3);
        l1.addNode(3);
        l1.addNode(3);
        l1.addNode(4);
        l1.addNode(4);
        l1.addNode(4);
        l1.addNode(4);

        System.out.println("Original Linked List");
        printNodes(l1.getHead());

        System.out.println("Without Duplicates");
        Node<Integer> l2 = removeDuplicates(l1.getHead());
        printNodes(l2);
    }
}
