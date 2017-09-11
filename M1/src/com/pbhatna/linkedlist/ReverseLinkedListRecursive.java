package com.pbhatna.linkedlist;

/**
 * Reverse linked List using iterative approach
 */
public class ReverseLinkedListRecursive <T extends Comparable<T>> extends LinkedList {

    public static Node<Integer> getReverse(Node<Integer> head) {
        if (head == null || head.getNext() == null) {
            return head;
        }

        Node<Integer> second = head.getNext();
        head.setNext(null);

        Node<Integer> result = getReverse(second);
        second.setNext(head);

        return result;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        // creating first list
        list.addNode(7);
        list.addNode(5);
        list.addNode(9);
        list.addNode(4);
        list.addNode(6);

        System.out.print("First List is \n\n");
        list.printNodes();


        Node<Integer> list1 = getReverse(list.getHead());
        printNodes(list1);
    }
}
