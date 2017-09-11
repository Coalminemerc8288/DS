package com.pbhatna.linkedlist;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example, given 1->2->3->4, you should return the list as 2->1->4->3.
 * Your algorithm should use only constant space.
 * You may not modify the values in the list, only nodes itself can be changed.
 */
public class SwapNodesInPairs extends LinkedList {

    public static Node<Integer> getSwappedNodes(Node<Integer> head) {
        if (head == null || head.getNext() == null) {
            return head;
        }

        Node<Integer> h = new Node<>(0);
        h.setNext(head);

        Node<Integer> p = h;

        while (p.getNext() != null && p.getNext().getNext()!= null) {
            Node<Integer> t1 = p;
            p = p.getNext();
            t1.setNext(p.getNext());

            Node<Integer> t2 = p.getNext().getNext();
            p.getNext().setNext(p);
            p.setNext(t2);
        }

        return h.getNext();
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        // creating first list
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);

        System.out.print("First List is \n\n");
        list.printNodes();


        Node<Integer> list1 = getSwappedNodes(list.getHead());
        printNodes(list1);
    }
}
