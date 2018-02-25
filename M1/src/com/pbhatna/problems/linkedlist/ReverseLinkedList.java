package com.pbhatna.linkedlist;

/**
 * Reverse all the nodes in the linked list so that the last node
 * becomes the first node.
 */
public class ReverseLinkedList<T extends Comparable<T>> extends LinkedList {

    public static Node<Integer> reverseList(Node<Integer> head) {
        if(head == null || head.getNext() == null) {
            return head;
        }

        Node<Integer> prev = null;
        Node<Integer> curr = head;
        while (curr != null) {
            Node<Integer> next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }

        head = prev;

        return head;
    }

    public static void main(String[] args) {

        LinkedList<Integer> n = new LinkedList<Integer>();
        n.addNode(1);
        n.addNode(2);
        n.addNode(3);
        n.addNode(4);

        System.out.println("Printing all nodes through printnode function" );
        n.printNodes(); //  to print all the nodes
        printNodes(reverseList(n.getHead()));
    }

}
