package com.pbhatna.linkedlist;

/**
 * Write a removeDuplicates() function which takes a list sorted in non-decreasing order and deletes any duplicate nodes from the list.
 * The list should only be traversed once.
 * For example if the linked list is 11->11->11->21->43->43->60 then removeDuplicates() should convert the list to 11->21->43->60.
 */
public class RemoveDuplicates<T extends Comparable<T>> extends LinkedList {

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
