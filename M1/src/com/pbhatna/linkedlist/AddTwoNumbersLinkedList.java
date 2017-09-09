package com.pbhatna.linkedlist;

/**
 * Leetcode – Add Two Numbers (Java)
 *
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class AddTwoNumbersLinkedList <T extends Comparable<T>> extends LinkedList {


    public Node<T> addTwoNumbers(Node<T> l1, Node<T> l2) {
        int carry = 0;

        Node<T>l3 = new  Node(0);

        Node<T> p1 = l1;
        Node<T> p2 = l2;
        Node<T> p3 = l3;
        return null;

    }


//    void printList(Node head) {
//        while (head != null) {
//            System.out.print(head.data + " ");
//            head = head.next;
//        }
//        System.out.println("");
//    }
//
//    public static void main(String[] args) {
//        LinkedList list = new LinkedList();
//
//        // creating first list
//        list.head1 = new Node(7);
//        list.head1.next = new Node(5);
//        list.head1.next.next = new Node(9);
//        list.head1.next.next.next = new Node(4);
//        list.head1.next.next.next.next = new Node(6);
//        System.out.print("First List is ");
//        list.printList(head1);
//
//        // creating seconnd list
//        list.head2 = new Node(8);
//        list.head2.next = new Node(4);
//        System.out.print("Second List is ");
//        list.printList(head2);
//
//        // add the two lists and see the result
//        Node rs = list.addTwoLists(head1, head2);
//        System.out.print("Resultant List is ");
//        list.printNodes(rs);
//    }
}
