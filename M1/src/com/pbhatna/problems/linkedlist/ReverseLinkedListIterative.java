package com.pbhatna.problems.linkedlist;

/**
 * Reverse linked List using iterative approach
 */
public class ReverseLinkedListIterative<T extends Comparable<T>> extends LinkedList {

    public static Node<Integer> getReverse(Node<Integer> head) {
        if (head == null) {
            return new Node<>();
        }

        Node<Integer> curr = head;
        Node<Integer> next = head.getNext();

        head.setNext(null);

        while (curr != null && next != null) {
            Node<Integer> temp = next.getNext();
            next.setNext(curr);
            curr = next; // increment current(first) pointer
            next = temp; // increment second(next) pointer
        }
        return curr;
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
