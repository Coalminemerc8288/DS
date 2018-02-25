package com.pbhatna.problems.linkedlist;

/**
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class AddTwoNumbersLinkedList<T extends Comparable<T>> extends LinkedList {

    public static Node<Integer> addTwoNumbers(Node<Integer> l1, Node<Integer> l2) {

        int carry = 0;
        Node<Integer> l3 = new Node<Integer>();

        Node<Integer> p1 = l1;
        Node<Integer> p2 = l2;
        Node<Integer> p3 = l3;

        while (p1 != null || p2 != null) {
            if (p1 != null) {
                carry = carry + (int) p1.getData();
                p1 = p1.getNext();
            }

            if (p2 != null) {
                carry = carry + (int) p2.getData();
                p2 = p2.getNext();
            }
            p3.setNext(new Node<Integer>(carry % 10));
            carry = carry/ 10;
            p3 = p3.getNext();
        }

        if(carry == 1) {
            p3.setNext(new Node<Integer>(carry));
        }


     return l3;
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

        // creating seconnd list
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.addNode(8);
        list1.addNode(4);
        System.out.print("Second List is \n\n");
        list1.printNodes();

        // add the two lists and see the result
        Node<Integer> rs = addTwoNumbers(list.getHead(), list1.getHead());
        System.out.print("Resultant List is \n\n");
        printNodes(rs);
    }
}
