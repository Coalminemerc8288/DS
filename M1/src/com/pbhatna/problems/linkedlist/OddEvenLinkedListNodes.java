package com.pbhatna.problems.linkedlist;

/**
 * Given a singly linked list, group all odd nodes together followed by the even nodes.
 * Please note here we are talking about the node number and not the value in the nodes.
 *
 * Given 1->2->3->4->5->NULL,
 * return 1->3->5->2->4->NULL.
 */
public class OddEvenLinkedListNodes extends LinkedList {

    public static Node<Integer> getOddEvenList(Node<Integer> head) {
        if (head == null) {
            return new Node();
        }

        Node<Integer> p1 = head;               // beginning of odd list
        Node<Integer> p2 = head.getNext();     // beginning of even list
        Node<Integer> p3 = p2;    // save the reference of head of even list for later to merge

        while (p2 != null && p2.getNext()!= null) {
            p1.setNext(p2.getNext());
            p1 = p1.getNext();

            p2.setNext(p1.getNext());
            p2 = p2.getNext();
        }
        p1.setNext(p3.getNext());
        return head;
    }
    public static void main(String args[]) {

        LinkedList<Integer> l1 = new LinkedList<Integer>();
        System.out.println(l1);
        l1.addNode(11);
        l1.addNode(10);
        l1.addNode(8);
        l1.addNode(6);
        l1.addNode(4);
        l1.addNode(2);
        l1.addNode(0);

        System.out.println("Original Linked List");
        printNodes(l1.getHead());

        System.out.println("Segregated Linked List");
        Node<Integer> l2 = getOddEvenList(l1.getHead());
        printNodes(l2);
    }
}
